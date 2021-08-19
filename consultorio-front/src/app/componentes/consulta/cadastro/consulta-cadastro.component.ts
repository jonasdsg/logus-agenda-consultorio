import { Consulta } from './../../../models/consulta.model';
import { Component, OnInit } from "@angular/core";
import { FormBuilder } from "@angular/forms";
import { ConsultaService } from './../consulta.service';

@Component({
    templateUrl: 'consulta-cadastro.component.html'
})
export class ConsultaCadastroComponent implements OnInit {
    constructor(private fb: FormBuilder,
        private consultaService: ConsultaService) { }

    ngOnInit(): void {
        this.consultaService.findAll().subscribe(console.log)
    }


    getConsultaFormulario(e){
        console.log(e)
    }

    salvar(consulta:Consulta) {
        this.consultaService.save(consulta).subscribe(e=>{
            console.log(e)
        })
    }

    private _findMedico() {

    }

}
