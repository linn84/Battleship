package se.miun.student.dt042g;
/*
 *  Ship-klassens logik f�r checkShot mm �r fullt beroende av att 
 *  	startX samt startY �r de l�gre v�rdena relativt p� griden, ej ub�t.
 * 	
 *  length �r inte h�rdkodat n�gonstans och �r beroende av korrekt anv�ndande:
 *  	-> submarine 1, destroyer 3, carrier 5.
 */
public class Ship {
	public final int startX;
	public final int startY;
	public final int length;
	public final boolean xAligned; // S�tts till true om skeppet ligger p� X-axel
	public final EnumCellStatus type;
	private int hits; // Antal tr�ffar skeppet t�l, stegas ner till 0
	
	public Ship( int startX, int startY, int length, boolean xAligned ){
		this.startX = startX;
		this.startY = startY;
		this.length = length;
		this.xAligned = xAligned;
		
		hits = length;
		switch (length){
		case 1:
			type  = EnumCellStatus.SUBMARINE;
			break;
		case 3:
			type = EnumCellStatus.DESTROYER;
			break;
		case 5:
			type = EnumCellStatus.CARRIER;
			break;
		default:
			type = EnumCellStatus.MISS; // Trasig initiering				
		}
	}

	public boolean checkShot(int x, int y){
	
		for(int i=0; i<length; i++){
			
			if( xAligned && x == startX + i && y == startY){
				hits--;
				return true;
			}
			if( !xAligned && x == startX && y == startY + i){
				hits--;
				return true;
			}
		}	
		
		return false;
	}
	
	
	
	public boolean isSunk(){
		return ( hits <= 0 );
	}
	
}
