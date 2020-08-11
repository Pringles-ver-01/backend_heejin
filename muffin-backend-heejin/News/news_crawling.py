from bs4 import BeautifulSoup
import requests
import re
import pandas as pd
import datetime
from pandas import DataFrame
import csv

# 최근 3일 기준 썸네일 없는 부분까지 전체 페이지 csv 파일 생성 코드
# 썸네일 없는 부분 공백인데 공백 처리는 화면에 띄울 때 if로
# 저장되는 csv 파일은 data directory에

class NewsCrawler:

    def date(self):
        date = []
        today = datetime.date.today()
        d = today - datetime.timedelta(+2)
        three_days = d.strftime("%Y%m%d")
        today = today.strftime("%Y%m%d")
        dt_index = pd.date_range(start=three_days, end=today)
        dt_list = dt_index.strftime("%Y%m%d").tolist()
        for i in dt_list:
            date.append(i)
        return date


    def news_crawling(self, page_number):
        result = []
        date = self.date()
        for regDate in date:
            for i in range(page_number):
                    url = "https://finance.naver.com/news/news_list.nhn?mode=LSS3D&section_id=101&section_id2=258&section_id3=402" \
                      "&date={date}&page={page}".format(date=regDate, page=i)
                    html = requests.get(url).text
                    soup = BeautifulSoup(html, 'html.parser')
                    a = soup.find_all('dd', {'class': 'articleSubject'})
                    for item in a:
                        title = item.find('a')['title']
                        link = str('https://finance.naver.com{}') \
                            .format(item.find('a')['href']
                                    .replace("§", "&sect"))
                        wdate = self.get_wdate(link)
                        content = self.get_text(link)
                        thumbnail = self.get_thumbnail(link)
                        news = {wdate : "wdate", title : "title", link: "link", thumbnail : "thumbnail", content : "content"}
                        result.append(news)

                    b = soup.find_all('dt', {'class': 'articleSubject'})
                    for item in b:
                        title = item.find('a')['title']
                        link = str('https://finance.naver.com{}') \
                            .format(item.find('a')['href']
                                    .replace("§", "&sect"))
                        wdate = self.get_wdate(link)
                        content = self.get_text(link)
                        news = {wdate : "wdate", title: "title", link: "link", content: 'content'}
                        result.append(news)
        self.get_csv(result)
        return result

    def get_csv(self,result):
        file = open('../data/news_crawling.csv','w',encoding='utf-8',newline='')
        csvfile = csv.writer(file)
        for row in result:
            csvfile.writerow(row)
        file.close()




    def get_wdate(self, url):
        html = requests.get(url).text
        soup = BeautifulSoup(html, 'html.parser')
        written_date = soup.find_all(class_='article_sponsor')
        for date in written_date:
            wdate = date.find('span').text
            return wdate

    def get_thumbnail(self, url):
        html = requests.get(url).text
        soup = BeautifulSoup(html, 'html.parser')
        article_image = soup.find_all(class_='end_photo_org')
        for item in article_image:
            src = item.find('img')['src']
            return src

    def get_text(self, url):
        html = requests.get(url).text
        soup = BeautifulSoup(html, 'html.parser')
        content = ''
        for item in soup.find_all('div', {'id': 'content'}):
            for text in item.find_all(text=True):
                if re.search('▶', text) is not None:
                    break
                content = content + text + "\n\n"
        return content


if __name__ == '__main__':
    test = NewsCrawler()
    crawl = test.news_crawling(page_number=100)