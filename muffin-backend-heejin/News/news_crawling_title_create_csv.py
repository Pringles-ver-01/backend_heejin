from bs4 import BeautifulSoup
import requests
import re
import pandas as pd
import datetime
import csv

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
        title_result = []
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
                        news_title = {title : 'title'}
                        print(news_title)
                        title_result.append(news_title)

                    b = soup.find_all('dt', {'class': 'articleSubject'})
                    for item in b:
                        title = item.find('a')['title']
                        news_title = {title : 'title'}
                        title_result.append(news_title)
                        print(news_title)
        self.get_csv(title_result)
        return title_result

    def get_csv(self,title_result):
        file = open('../data/title_result.csv', 'w', encoding='utf-8', newline='')
        csvfile = csv.writer(file)
        for row in title_result:
            csvfile.writerow(row)
        file.close()

if __name__ == '__main__':
    test = NewsCrawler()
    crawl = test.news_crawling(page_number=100)