import { Medico } from './../../../models/medico.model';
import { MedicoService } from './../medico.service';
import { Component } from "@angular/core";

@Component({
    templateUrl: 'medico-cadastro.component.html'
})
export class MedicoCadastroComponent {

    constructor(private medicoService:MedicoService){}

    salvar(medico:Medico){
        console.log(medico)
        this.medicoService.save(medico).subscribe(e=>{
            console.log(e)
        });
    }
}