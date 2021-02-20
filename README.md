# Postar Textos com a opção de curtir ou não.



## Realize o git clone no terminal

```
git clone https://github.com/sandersonferraz/apiTextPostingUpVote.git


```



## Rode o script start.bash na raiz da pasta

```
sh ./start.sh
```

### O script realizará as seguintes tarefas:

1. Criar uma container mongoDB

   ```
   docker run --name mangodb -d  -p 27017:27017 mongo:latest
   ```

   

2. Criar um container para app-client (Reactjs)

   ```
   docker-compose up -d --build
   ```

   

3. Executar a aplicação spring boot .jar

   ```
   java -jar target/textPostUpvote-0.0.1-SNAPSHOT.jar
   ```

   

