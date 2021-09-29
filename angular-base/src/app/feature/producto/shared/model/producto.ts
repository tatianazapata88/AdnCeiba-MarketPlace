import { Usuario } from "@usuario/shared/model/usuario";

export class Producto {
    id: number;
    marca: string;
    modelo: number;
    precio: number;
    ciudad: string;
    vendedor: Usuario;
    foto: string;
    estado: string;

    constructor(){}

    guardar(marca: string,modelo: number, precio: number, ciudad: string, vendedor: Usuario, foto: string) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio =precio;
        this.ciudad = ciudad;
        this.vendedor = vendedor;
        this.foto = foto;
      

    }
}
