import { Medico } from './../../models/medico.model';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";

@Component({
    selector: 'medico-component',
    templateUrl: 'medico.component.html'
})
export class MedicoComponent implements OnInit {
    public medicoForm: FormGroup;
    @Input()
    public nomeBotao: string;
    @Input()
    public nomeTela: string;
    @Output()
    public aoEmitirMedico: EventEmitter<Medico> = new EventEmitter<Medico>();

    constructor(private fb: FormBuilder) { }
    ngOnInit(): void {
        this.medicoForm = this.fb.group({
            nomeMedico: null,
            crm: null,
            nascimento: null
        })
    }

    getParams(): Medico {

        let form = this.medicoForm.getRawValue();
        let param: Medico = {
            id: null,
            nome: form.nomeMedico,
            crm: form.crm,
            nascimento: form.nascimento,
        }

        return param;
    }

    getData(data: string) {
        this.medicoForm.get('nascimento').setValue(data)
    }

    emitir() {
        this.aoEmitirMedico.emit(this.getParams());
    }
}