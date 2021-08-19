import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { FormBuilder, FormGroup } from '@angular/forms';
import { Consulta } from './../../models/consulta.model';

@Component({
    selector: 'campos-consulta',
    templateUrl: './consulta.component.html'
})
export class ConsultaComponent implements OnInit {
    @Output()
    public dadosFormulario: EventEmitter<Consulta> = new EventEmitter();
    @Input()
    public consulta: Consulta;
    @Input()
    public nomeBotao:string;
    
    public consultaForm: FormGroup = null;

    constructor(private fb: FormBuilder) { }

    ngOnInit(): void {
        this.consultaForm = this.fb.group({
            nomePaciente: null,
            nomeDoMedico: null,
            especialidade: null,
            data: null,
            crm: null,
            numeroConsultorio: null
        })
    }

    emissor() {
        let consulta:Consulta = this.getParams();
        this.dadosFormulario.emit(consulta);
    }

    getParams(): Consulta {    
        let form: FormConsulta = this.consultaForm.getRawValue();
        
        let consulta:Consulta = {
            id:null,
            nomePaciente: form.nomePaciente,
            data:form.data,
            especialidade:form.especialidade,
            numeroConsultorio:form.numeroConsultorio,
            medicos:[
                {
                    id:null,
                    crm: form.crm,
                    nome: form.nomeDoMedico,
                    nascimento: null           
                }
            ]
        };
        
        return consulta;
    }
    
    salvar(){}
}


type FormConsulta = {
    nomePaciente
    nomeDoMedico
    especialidade
    data
    crm
    numeroConsultorio
}
