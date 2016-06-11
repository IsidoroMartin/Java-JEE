package cursosbasicos;

public class Alumno extends Persona {
	private byte nota;
	private NotaCualitativa notaCualitativa;

	private enum NotaCualitativa {
		Insuficiente, Suficiente, Bien, Notable, Sobresaliente
	};

	public Alumno(byte nota, byte edad, String nombre, String apellido) {
		super(edad, nombre, apellido);
		this.nota = nota;
		notaCualitativa = traducirNota();

	}

	private NotaCualitativa traducirNota() {
		NotaCualitativa notaCualitativa = null;
		switch (nota) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			notaCualitativa = NotaCualitativa.Insuficiente;
			break;
		case 5:
			notaCualitativa = NotaCualitativa.Suficiente;
			break;
		case 6:
		case 7:
			notaCualitativa = NotaCualitativa.Bien;
			break;
		case 8:
		case 9:
			notaCualitativa = NotaCualitativa.Notable;
			break;
		case 10:
			notaCualitativa = NotaCualitativa.Sobresaliente;
			break;
		}
		return notaCualitativa;
	}

	public byte getNota() {
		return nota;
	}

	public void setNota(byte nota) {
		this.nota = nota;

	}

	public NotaCualitativa getNotaCualitativa() {
		return notaCualitativa;
	}

	public void setNotaCualitativa(NotaCualitativa notaCualitativa) {
		this.notaCualitativa = notaCualitativa;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + String.valueOf(this.nota);
	}
}
