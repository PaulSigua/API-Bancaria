import { Component } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.scss'
})
export class MenuComponent {

  pages = [
    { path: 'inicio', link: 'Inicio'},
    { path: 'perfil', link: 'Perfil'},
    { path: 'registro', link: 'Registro'},
  ];

}
