import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Medico } from './../../models/medico.model';
import { BackendService } from './../BackendService.model';

@Injectable({
    providedIn: 'root'
})
export class MedicoService extends BackendService<Medico> {
    constructor(http:HttpClient){
        super('medico',http);
    }   
}