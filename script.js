const form = document.querySelector("form");

const iName = document.querySelector(".nome");
const iEmail = document.querySelector(".email");
const iPassword = document.querySelector(".senha");
const iTel = document.querySelector(".tel");

function register() {
  fetch("http://localhost:8080/register", {
    headers: {
      'Accept':  'application/json',
      'Content-Type': 'application/json',
    },
    method: "POST",
    body: JSON.stringify({
      nome: iName.value,
      email: iEmail.value,
      senha: iPassword.value,
      telefone: iTel.value,
    })
  })
    .then(function (res) {
        console.log(res);
    })
    .catch(function (res) {
      console.log(res);
    })
};

function clean() {
  iName.value = ""; 
  iEmail.value = "";
  iPassword.value = ""; 
  iTel.value = "";
};

form.addEventListener('submit', function (event) {
  event.preventDefault();

  register();
  clean();
});
