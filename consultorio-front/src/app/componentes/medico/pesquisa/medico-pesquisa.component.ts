import { MedicoService } from './../medico.service';
import { Medico } from './../../../models/medico.model';
import { Component } from "@angular/core";
import { DatePipe } from '@angular/common';

@Component({
    templateUrl: 'medico-pesquisa.component.html'
})
export class MedicoPesquisaComponent {
    public medicos:any;

    constructor(private medicoService:MedicoService){}

    calcularIdade(data:Date){
        return new Date().getFullYear() - new Date(data).getFullYear();
    }

    buscar(medico:Medico){
       this.medicoService.findByFilters(medico).subscribe(resp =>{
        this.medicos = resp;
       })
    }
}