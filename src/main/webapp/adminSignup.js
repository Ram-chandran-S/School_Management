let mess = document.createElement("b");
mess.textContent = "";
let parent = document.getElementById("mess");
parent.appendChild(mess);
function check() {
  let pass = document.getElementById("pass").value;
  let confirmpass = document.getElementById("repass").value;
  console.log(pass);
  console.log(confirmpass);

  if (pass != "" && confirmpass != "") {
    if (pass == confirmpass) {
      if (mess.textContent != "") {
        mess.textContent = "";
        mess.textContent = "Password Matched";
        mess.style.color = "green";
      } else {
        mess.textContent = "Password Matched";
        mess.style.color = "green";
      }
    } else {
      if (mess.textContent != "") {
        mess.textContent = "";
        mess.textContent = "Password Miss Matched";
        mess.style.color = "red";
      } else {
        mess.textContent = "Password Miss Matched";
        mess.style.color = "red";
      }
    }
  }
}
document.getElementById("pass").addEventListener("focusout", check);
document.getElementById("repass").addEventListener("focusout", check);
