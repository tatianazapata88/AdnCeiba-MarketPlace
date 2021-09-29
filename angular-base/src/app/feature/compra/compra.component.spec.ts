import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';
import { of } from 'rxjs/internal/observable/of';
import { CompraComponent } from './compra.component';
import { CompraService } from './shared/service/compra.service';

describe('CompraComponent', () => {
  //let component: CompraComponent;
  let fixture: ComponentFixture<CompraComponent>;
  let compraService : CompraService;
  const valorEsperado = true;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompraComponent ]
    })
    .compileComponents();
  });
  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CompraComponent ],
      imports: [
        HttpClientTestingModule,
       
        ReactiveFormsModule,
       
        RouterTestingModule
      ],
      providers: [CompraService, HttpService]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompraComponent);
   // component = fixture.componentInstance;
    compraService = TestBed.inject(CompraService);

    spyOn(compraService, 'guardar').and.returnValue(of(valorEsperado));
    fixture.detectChanges();
  });
/*
  it('should create', () => {
    expect(component).toBeTruthy();
  });*/

/*  it('debería agregar una compra', () => {

    (document.getElementById('fecha') as HTMLInputElement).value = '2021-9-29';
    (document.getElementById('ciudadDestinoEnvioScotter') as HTMLInputElement).value = 'medellin';
    

    document.getElementById('btnComprar').click();

    expect(component).toBeTruthy;
  });*/
});
