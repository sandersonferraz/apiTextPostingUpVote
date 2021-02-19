FROM node:14

WORKDIR /usr/src/app/app

COPY package*.json ./

RUN npm install

EXPOSE 3000

CMD ["npm", "start"]