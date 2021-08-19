import { Medico } from './medico.model';
export type Consulta = {
    id:number,
    nomePaciente: string,
    medicos:Medico[],
    data:string,
    numeroConsultorio:number,
    especialidade:string
}



