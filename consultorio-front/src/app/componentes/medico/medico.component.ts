import { Medico } from './../../models/medico.model';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";

@Component({
    selector:'medico-component',
    templateUrl: 'medico.component.html'
})
export class MedicoComponent implements OnInit {
    public medicoForm:FormGroup;
    @Input()
    public nomeBotao:string;
    @Output()
    private aoEmitirMedico:EventEmitter<Medico> = new EventEmitter<Medico>();

    constructor(private fb:FormBuilder){}
    ngOnInit(): void {
        this.medicoForm = this.fb.group({
            nomeMedico:null,
            crm:null,
            nascimento:null
        })
    }
    public emitir(){}
}