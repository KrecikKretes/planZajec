package com.zawisza.planZajec;

import com.zawisza.planZajec.model.*;
import com.zawisza.planZajec.repository.*;
import com.zawisza.planZajec.service.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class PlanZajecApplication {

	private final GrupyRepository grupyRepository;
	private final SaleRepository saleRepository;
	private final WykladowcyRepository wykladowcyRepository;
	private final ZajeciaRepository zajeciaRepository;
	private final PlanRepository planRepository;
	private final GrupyGrupRepository grupyGrupRepository;

	private final WykladowcyService wykladowcyService;
	private final GrupyGrupService grupyGrupService;
	private final SaleService saleService;
	private final ZajeciaService zajeciaService;
	private final GrupyService grupyService;

	public static void main(String[] args) {
		SpringApplication.run(PlanZajecApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void start(){
		System.out.println("------------------- Application is started -------------------");
		System.out.println();

		System.out.println("------------------- Connect to database -------------------");

		connectToDatabase();

		System.out.println();
		System.out.println("------------------- Read data -------------------");

		try {
			readData();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		System.out.println("------------------- Read data complete -------------------");
	}

	private void connectToDatabase() {
        Connections.connectToDatabase();
	}

	private void readData() throws SQLException {

		System.out.println("Grupy start");
		try{
			readGrupy();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Grupy complete");

		System.out.println();

		System.out.println("Sale start");
		try{
			readSale();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Sale complete");

		System.out.println();

		System.out.println("Wykladowcy start");
		try{
			readWykladowcy();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Wykladowcy complete");

		System.out.println();

		System.out.println("Zajecia start");
		try{
			readZajecia();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Zajecia complete");

		System.out.println();

		System.out.println("Plan start");
		try{
			readPlan();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Plan complete");
	}

	private void readPlan() throws SQLException{
				ResultSet rs = Connections.executeQuery("SELECT * FROM plan");
		while (rs.next()) {
			int id = rs.getInt(1);
			String dzien = rs.getString(2);
			String godzina = rs.getString(3);
			String tydzien = rs.getString(4);
			int idGG = rs.getInt(5);
			int idSale = rs.getInt(6);
			int idWykladowcy = rs.getInt(7);
			int idZajecia = rs.getInt(8);

			GrupyGrup grupyGrup = grupyGrupService.findGrupyGrupById(idGG);
			Sale sale = saleService.getSaleById(idSale);
			Wykladowcy wykladowcy = wykladowcyService.findWykladowcyById(idWykladowcy);
			Zajecia zajecia = zajeciaService.findZajeciaById(idZajecia);

			Plan plan = new Plan(id, tydzien,godzina, dzien, grupyGrup, sale, wykladowcy, zajecia);

			planRepository.save(plan);
		}
		rs.close();
	}

	private void readZajecia() throws SQLException{
		ResultSet rs = Connections.executeQuery("SELECT * FROM zajecia");
		while (rs.next()) {
			Zajecia zajecia = new Zajecia(rs.getInt(1), rs.getString(2));
			zajeciaRepository.save(zajecia);
		}
		rs.close();
	}

	private void readWykladowcy() throws SQLException{

        ResultSet rs = Connections.executeQuery("SELECT * FROM wykladowcy");
        while (rs.next()) {
            Wykladowcy wykladowcy = new Wykladowcy(rs.getInt(1) ,rs.getString(2), rs.getString(3), rs.getInt(4));
            wykladowcyRepository.save(wykladowcy);
        }
        rs.close();
	}

	private void readSale() throws SQLException{

		ResultSet rs = Connections.executeQuery("SELECT * FROM sale");
		while (rs.next()) {
			Sale sale = new Sale(rs.getInt(1) ,rs.getString(2), rs.getInt(3));
			saleRepository.save(sale);
		}
		rs.close();
	}

	private void readGrupy() throws SQLException{
		ResultSet rs = Connections.executeQuery("SELECT * FROM grupy");
		while (rs.next()) {
			Grupy grupy = new Grupy(rs.getInt(1), rs.getString(2));
			grupyRepository.save(grupy);
		}

		rs.close();

		ResultSet rs1 = Connections.executeQuery("SELECT * FROM grupyGrup");

		while (rs1.next()) {
			GrupyGrup grupyGrup = new GrupyGrup(rs1.getInt(1) ,rs1.getString(2), grupyService.getGrupyById(rs1.getInt(3)));
			Grupy grupy = grupyService.getGrupyById(rs1.getInt(3));
			grupy.addGrupyGrup(grupyGrup);
			grupyGrupRepository.save(grupyGrup);
		}
		rs1.close();
	}
}
