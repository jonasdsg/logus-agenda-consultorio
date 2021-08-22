import { Medico } from './../../../models/medico.model';
import { Component } from "@angular/core";

@Component({
    templateUrl: 'medico-pesquisa.component.html'
})
export class MedicoPesquisaComponent {
    calcularIdade(data:Date){

    }

    buscar(medico:Medico){
        console.log(medico)
    }
}