import { Consulta } from './../../../models/consulta.model';
import { Medico } from './../../../models/medico.model';
import { Component, Input } from "@angular/core";

@Component({
    selector: 'consulta-listagem',
    templateUrl: './consulta-listagem.component.html'
})
export class ConsultaListagemComponent {
    @Input() consultas:Consulta[];

    nomeMedicoResponsavel(medicos:Medico[]){
        return medicos.join(',');
    }
}