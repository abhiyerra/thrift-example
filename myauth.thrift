namespace rb MyAuth
namespace py myauth

struct User {
  1: string username,
  2: string password
}

enum LoginStatus {
  SUCCESS,
  FAIL
}

service Authentication {
  string say_hello(),
  LoginStatus login(1:User cred)
}
