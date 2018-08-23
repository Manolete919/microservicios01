FROM python:3.6.1-alpine
RUN apk update && apk add build-base
RUN ln -s /usr/include/locale.h /usr/include/xlocale.h
RUN pip install numpy