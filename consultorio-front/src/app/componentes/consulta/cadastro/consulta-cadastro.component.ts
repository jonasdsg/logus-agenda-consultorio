import { Component, OnInit } from "@angular/core";
import { FormBuilder } from "@angular/forms";
import { ConsultaService } from './../consulta.service';

@Component({
    templateUrl: 'consulta-cadastro.component.html'
})
export class ConsultaCadastroComponent implements OnInit {
    message: string = "Rota cadastro funcionando!"
    constructor(private fb: FormBuilder,
        private consultaService: ConsultaService) { }

    ngOnInit(): void {
        this.consultaService.findAll().subscribe(console.log)
    }


    getConsultaFormulario(e){
        console.log(e)
    }

    salvar() {

    }

    private _findMedico() {

    }

}
