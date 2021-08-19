import { Consulta } from './../../../models/consulta.model';
import { ConsultaService } from './../consulta.service';
import { Component } from "@angular/core";

@Component({
    templateUrl: 'consulta-pesquisa.component.html'
})
export class ConsultaPesquisaComponent {
    public consultas:any[] = null;
    
    constructor(private consultaService: ConsultaService) { }

    buscarConsultas(consulta: Consulta) {
        this.consultaService.findByFilters(this.getParams(consulta)).subscribe(resp=>{
            this.consultas = (resp as any);
        })
    }

    private getParams(consulta?: Consulta) {
        let params: any = {};
        if (consulta.data) {
            params.data = consulta.data;
        }
        if (consulta.especialidade) {
            params.especialidade = consulta.especialidade;
        }
        if (consulta?.medicos?.length > 0) {
            params.crm = consulta.medicos[0].crm;
        }
        if (consulta.nomePaciente) {
            params.nomePaciente = consulta.nomePaciente;
        }

        return params;
    }
}