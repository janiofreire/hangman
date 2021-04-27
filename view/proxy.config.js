const proxy = [
    {
      context: '/hangman',
      target: 'http://localhost:8080',
      pathRewrite: {'^/hangman' : ''}
    }
  ];
  module.exports = proxy;