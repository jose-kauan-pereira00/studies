const http = require('http');

const server = http.createServer((request, response) => {

  if(request.url == '/teste'){
    response.setHeader('Content-type', 'text-html');

    response.end('<h1>Ola Mundo!</h1>');
  }
  console.log('Servidor Acessado!');

  const headers = request.headers;

  const method = request.method;

  const url = request.url;

  console.log("Headers");
  console.log(headers);

  console.log("methods: "+ method);

  console.log("URL: " + url);



});

server.listen(3000);
