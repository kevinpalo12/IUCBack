package api.iuc.iucback.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.iuc.iucback.entity.Estudiante;
import api.iuc.iucback.entity.Grupo;
import api.iuc.iucback.repository.EstudianteDao;
import api.iuc.iucback.repository.GrupoDao;

@Service
public class EstudianteService implements IEstudianteService {

	@Autowired
	private EstudianteDao estudianteDao;
	
	
	
	@Override
	@Transactional
	public Estudiante save(Estudiante estudiante) {
		if (estudiante.getNacimiento()!=null) {
			estudiante.setEdad(calcularEdad(estudiante));
		}		
		return estudianteDao.save(estudiante);
	}



	@Override
	@Transactional(readOnly=true)
	public List<Estudiante> findAll() {
		return estudianteDao.findAll();
	}



	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> porGrupo(Long grupo) {		
		System.out.println(grupo);
		return estudianteDao.estudiantesGrupo(grupo);
	}



	@Override
	@Transactional(readOnly = true)
	public Estudiante findById(Long id) {
		return estudianteDao.findById(id).orElse(null);
	}



	@Override
	public Integer calcularEdad(Estudiante estudiante) {
		Date fechaNac=estudiante.getNacimiento();
	       
	       Calendar fechaNacimiento = Calendar.getInstance();
	       //Se crea un objeto con la fecha actual
	       Calendar fechaActual = Calendar.getInstance();
	       fechaNacimiento.setTime(fechaNac);
	       //Se restan la fecha actual y la fecha de nacimiento
	       int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
	       int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
	       int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
	       //Se ajusta el año dependiendo el mes y el día
	       if(mes<0 || (mes==0 && dia<=0)){
	           año--;
	       }
	       
	       //Regresa la edad en base a la fecha de nacimiento
	       return año;
	   }
	

}
