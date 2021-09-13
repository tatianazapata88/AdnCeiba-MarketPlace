export class Compra {
    id: number;
    fecha: Date;
    scotterId: number;
    compradorId: number;
    ciudadDestinoEnvioScotter: string;
    flete: Number;
    precio: number;
    descuento: number;
    total: number;

    constructor(){}

   guardar(id: number, fecha: Date, scotterId: number, compradorId: number, ciudadDestinoEnvioScotter: string){
       this.id=id;
       this.fecha=fecha;
       this.scotterId=scotterId;
       this.compradorId=compradorId;
       this.ciudadDestinoEnvioScotter=ciudadDestinoEnvioScotter;
   } 

    
}