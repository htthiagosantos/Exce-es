package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import execao.DominioErro;

public class Reserva {
	
	private Integer NumeroDoQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut){
		if(!checkOut.after(checkIn)){
			throw new DominioErro("A data de check-out deve ser posterior à data de check-in");
		}
		
		NumeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getNumeroDoQuarto() {
		return NumeroDoQuarto;
	}


	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		NumeroDoQuarto = numeroDoQuarto;
	}


	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	
	public long duracao() {
		long diferente = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferente, TimeUnit.MILLISECONDS);
	}
	
	// ------------- ATUALIZAR AS DADAS -------------------------
	public void atualizacaoDeDatas(Date checkIn, Date checkOut) {
		
		Date agora = new Date();
		if(checkIn.before(agora) || checkOut.before(agora)) {
			throw new DominioErro("As datas de reserva para atualização devem ser datas futuras");
		}
		if(!checkOut.after(checkIn)){
			throw new DominioErro("A data de check-out deve ser posterior à data de check-in");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ NumeroDoQuarto + ", check-in: " + sdf.format(checkIn)
				+ ", check-out: " + sdf.format(checkOut) + ", " + duracao()
				+ " noites";
	}
	
	

}
