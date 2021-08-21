import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Consulta } from './../../models/consulta.model';
import { BackendService } from './../BackendService.model';

@Injectable({
    providedIn: 'root'
})
export class ConsultaService extends BackendService<Consulta> {
    constructor(http:HttpClient){
        super('consulta',http);
    }
}