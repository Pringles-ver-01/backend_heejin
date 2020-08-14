from dataclasses import dataclass
from nltk.tokenize import word_tokenize
from konlpy.tag import Okt
import collections
import re
from nltk import FreqDist
import pandas as pd

import csv

# 텍스트마이닝으로 top 30 키워드 csv 파일 저장 (wordcloud는 실행하지 x)


@dataclass
class Entity:
    context: str
    fname: str
    target: str

    @property
    def context(self) -> str: return self._context
    @context.setter
    def context(self, context): self._context = context

    @property
    def fname(self) -> str: return self._fname
    @fname.setter
    def fname(self, fname): self._fname = fname

    @property
    def target(self) -> str: return self._target
    @target.setter
    def target(self, target): self._target = target


class Service:
    def __init__(self):
        self.texts = []
        self.tokens = []
        self.noun_tokens = []
        self.okt = Okt()
        self.stopword = []
        self.freqtxt = []

    def extract_texts(self, payload):
        filename = payload.context + payload.fname
        with open(filename, 'r', encoding='utf-8') as f:
            self.texts = f.read()
        texts = self.texts.replace('\n','')
        tokenizer = re.compile(r'[^ㄱ-힣]')
        self.texts = tokenizer.sub(' ', texts)
        self.tokens = word_tokenize(self.texts)
        _arr = []
        for token in self.tokens:
            token_pos = self.okt.pos(token)
            _ = [txt_tag[0] for txt_tag in token_pos if txt_tag[1] == 'Noun']
            if len("".join(_)) > 1:
                _arr.append("".join(_))
        self.noun_tokens = " ".join(_arr)

    def extract_stopword(self, payload):
        filename = payload.context + payload.fname
        with open(filename, 'r', encoding='utf-8') as f:
            self.stopword = f.read()
        self.noun_tokens = word_tokenize(self.noun_tokens)
        self.noun_tokens = [text for text in self.noun_tokens
                            if text not in self.stopword]
        keyword_list = self.noun_tokens
        self.freqtxt = pd.Series(dict(FreqDist(keyword_list))).sort_values(ascending=False)
        print(f'{self.freqtxt[:30]}')
        c2 = collections.Counter(keyword_list)
        top_ten = list(c2.most_common(30))
        file = open('../data/top_30_keyword_ver2.csv', 'w', encoding='utf-8', newline='', )
        keywordCsv = csv.writer(file)
        for row in top_ten:
            keywordCsv.writerow(row)
        file.close()

class Controller:
    def __init__(self):
        pass
    def data_analysis(self):
        entity = Entity()
        service = Service()
        entity.context = '../data'
        entity.fname = '/news_crawling.csv'
        service.extract_texts(entity)
        entity.fname = '/stopwords.txt'
        service.extract_stopword(entity)

app = Controller()
app.data_analysis()
