FROM     python:3.6.5-alpine
WORKDIR  project
COPY     app.py install.txt   /project
RUN      apk update && apk upgrade
RUN      pip install flask
EXPOSE   5000
CMD      python app.py
