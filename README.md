# Definición de Asociación de Negocios

## Descripción

Esta aplicación servirá como gestor para una asociación; dicha asociación tendrá un conjunto de negocios.
El caso particular que se va a desarrollar tendrá exclusivamente dos tipos de negocios: farmacia y óptica.
Se podrán añadir, consultar, actualizar y eliminar negocios de dicha asociación.
Además, en un primer desarrollo, se permitirá consultar las asociaciones que tengan farmacias, ópticas o ninguna de las dos.

## Diagrama de clases de diseño

![Diagrama de Diseño MVP](https://git.institutomilitar.com/aGir18/proyecto-individual-asociacion-negocios/-/wikis/Imagenes/Alejandro_Gonzalez-modeloMVP_4.png)

**Cumplimiento de requisitos**

1. **Herencia**: Está presente entre `Negocio` y sus subtipos: `Farmacia` y `Optica`.
2. **Relación One-To-Many**: Relación entre `Asociacion` y `Negocio`.
3. **Método personalizado**: El método tendrá como parámetros dos Boolean: uno será para definir si *poseeFarmacia* y otro para definir si *poseeOptica*; devolverá una lista de asociaciones que tengan farmacias, ópticas o ninguna de las dos, dependiendo de los argumentos pasados al método.
4. **Listado**: Se mostrarán todos los negocios que componen la asociación, tanto las farmacias como las ópticas; se mostrará un listado como en la [Figura 1](#figura-1).
5. **CRUD**: En una pantalla diferente se usarán los controles adecuados para hacer el CRUD, como se puede ver en la [Figura 2](#figura-2). 
6. **URLs** del proyecto:
   1. Repositorio proyecto: https://git.institutomilitar.com/aGir18/animus-lucrandi 
   2. Librería: https://github.com/aGir18/animus-lucrandi-libreria-externa
7. **Despliegue** en Internet:
   1. API: TBD. <!--Enlace a la API-->
   2. Web: TBD. <!--Enlace a la Web-->

## Interfaz de usuario

#### Figura 1:

![Listado de negocios](https://git.institutomilitar.com/aGir18/proyecto-individual-asociacion-negocios/-/wikis/Imagenes/Listadov2.png)

#### Figura 2:
![CRUD de negocios](https://git.institutomilitar.com/aGir18/proyecto-individual-asociacion-negocios/-/wikis/Imagenes/CRUD_negociosv2.png)