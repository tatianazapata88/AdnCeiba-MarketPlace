import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoletoCompraComponent } from './boleto-compra.component';

describe('BoletoCompraComponent', () => {
  //let component: BoletoCompraComponent;
  let fixture: ComponentFixture<BoletoCompraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoletoCompraComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoletoCompraComponent);
   // component = fixture.componentInstance;
    fixture.detectChanges();
  });
/*
  it('should create', () => {
    expect(component).toBeTruthy();
  });*/
});
