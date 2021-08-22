import { DatePipe } from '@angular/common';
import { Directive, ElementRef, EventEmitter, HostListener, 
        Input, OnChanges, Output, SimpleChanges } from "@angular/core";

@Directive({
    selector: '[dataDirective]'
})
export class DataDirective implements OnChanges {
    @Input()
    public formato: string = 'data'
    private formatos = {
        data: 'yyyy-MM-dd',
        dataComHora: 'yyyy-MM-ddTHH:mm'
    }
    @Output()
    public aoEmitirData: EventEmitter<string> = new EventEmitter<string>();

    constructor(
        private _elementRef: ElementRef,
        private datePipe: DatePipe) {
        
    }
    
    ngOnChanges(changes: SimpleChanges): void {
        if (this.formato === 'dataComHora') {
            this._elementRef.nativeElement.placeholder = "dd/MM/yyyy HH:mm"
        }
        else {
            this._elementRef.nativeElement.placeholder = "dd/MM/yyyy"
        }
    }

    @HostListener("keyup")
    change() {
        let inputValue: string = this._elementRef.nativeElement.value;
        if (/[(\d){2}\/]{2}?\d{4}/.test(inputValue)) {
            inputValue.split('').forEach(() => inputValue = inputValue.replace('/', '-'))
            if (this.formato === 'data' && inputValue.length == 10) {
                let tmp = inputValue.split('-');
                this.emitir(this.datePipe.transform(`${tmp[2]}-${tmp[1]}-${tmp[0]}`, this.formatos[this.formato]))
            }
            if (this.formato === 'dataComHora' && inputValue.length == 16) {
                let aux = inputValue.split(' ');
                let tmp = aux[0].split('-');
                this.emitir(this.datePipe.transform(`${tmp[2]}-${tmp[1]}-${tmp[0]}T${aux[1]}`, this.formatos[this.formato]))
            }
        }
    }

    emitir(valor: string) {

        this.aoEmitirData.emit(valor);
    }
}