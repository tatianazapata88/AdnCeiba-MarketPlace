export class Usuario {
    id: number;
    username: string;
    nombre: string;
    celular: string;
    email: string;

    constructor(){
    }

    login(username: string, email: string){
    this.username=username;
    this.email=email;
    }
}
