package data;

import model.FizzBuzz;

public class FizzBuzzRepository extends AbstractRepository <FizzBuzz> {

	@Override
	public void create(FizzBuzz object) {
		if (getRep().size() == 0) {
			getRep().add(object);
		}
		else if (read(object) == null) {
			int i =0;
			while(i<getRep().size() && 
					getRep().get(i).getPoints() > object.getPoints()) {
				i = i+1;
			}
			getRep().add(i, object);
		}
		else {
			System.out.println(object + " ja esta cadastrado");
		}
		
	}
	
	
	public String top10() {
		String top10 = "";
		for (int i=0; i<getRep().size() && i<10; i++) {
			top10 += Integer.toString(i+1)+". " + getRep().get(i).getPlayer()+"\t"
					+getRep().get(i).getPoints()+" Pontos.\n";
		}
		
		return top10;
	}
	
}
