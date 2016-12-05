package ar.edu.grupoesfera.cursospring.modelo;

public class Cerradura {

	public Integer Valor;
	public Integer Contador;
	public Boolean Bloqueado;
	
	public Cerradura (){
		this.Contador=0;
		this.Bloqueado=false;
	}
	
	public Boolean abrir(Integer valor){
			
		if (valor==1 && Bloqueado==false){
			return true;	
			}
		else{
			Contador++;
			return false;
		}
	}	
	
	public Boolean contar(){
		if(Contador==3){
			Bloqueado = true;
			return Bloqueado;
		}
		else{
			Bloqueado = false;
			return Bloqueado;
		}
	}
}
