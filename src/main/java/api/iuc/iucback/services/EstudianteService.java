package api.iuc.iucback.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.iuc.iucback.entity.Ayuda;
import api.iuc.iucback.entity.Estudiante;
import api.iuc.iucback.repository.EstudianteDao;
import org.hibernate.type.TimestampType;

@Service
public class EstudianteService implements IEstudianteService {
	private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
	
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
		Date fechaNac= estudiante.getNacimiento();
	       
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



	@Override
	@Transactional(readOnly = true)
	public Page<Estudiante> findAll(Pageable pegeable) {
		return estudianteDao.findAll(pegeable);
	}



	@Override
	@Transactional(readOnly = true)
	public Page<Estudiante> filtrado(String nombre, String apellido,String id, int page) {	
		Pageable pageable = PageRequest.of(page, 10);
		List<Estudiante> estudiantes = estudianteDao.estudianteFiltro(nombre, apellido, id);
		List<Estudiante> fin = new ArrayList<>();
		int tamano = 10;
		if (page== estudiantes.size()/10 && estudiantes.size()%10<10) {
		  tamano=estudiantes.size()%10;		
			System.out.println("entro");
		}
		System.out.println(pageable.getPageNumber());
		System.out.println(estudiantes.size()/10);
		for (int i = 0; i < tamano; i++) {
			fin.add(estudiantes.get((i+(int) pageable.getOffset())));
		}
		

		Page<Estudiante> paginas = new PageImpl<Estudiante>(fin, pageable, estudiantes.size());
		return paginas;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Estudiante> porGrupoPage(Long grupo, int page) {	
		Pageable pageable = PageRequest.of(page, 10);
		List<Estudiante> estudiantes = estudianteDao.estudiantesGrupo(grupo);
		List<Estudiante> fin = new ArrayList<>();
		int tamano = 10;
		if (page== estudiantes.size()/10 && estudiantes.size()%10<10) {
		  tamano=estudiantes.size()%10;		
			System.out.println("entro");
		}
		System.out.println(pageable.getPageNumber());
		System.out.println(estudiantes.size()/10);
		for (int i = 0; i < tamano; i++) {
			fin.add(estudiantes.get((i+(int) pageable.getOffset())));
		}
		Page<Estudiante> paginas = new PageImpl<Estudiante>(fin, pageable, estudiantes.size());
		return paginas;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		estudianteDao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> findAyudas(Long id) {
		return estudianteDao.findAyudas(id);
	}
}
