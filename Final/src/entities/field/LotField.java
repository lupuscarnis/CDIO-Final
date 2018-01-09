package entities.field;

import entities.enums.FieldType;
import entities.enums.LotColor;
import entities.enums.LotRentTier;

/**
 * Added by Frederik on 05-01-2018 16:04:43
 *
 * Represents lot fields.
 */
// TODO: There is no need for a diff. house/hotel cost price.
// Cost of building is returned via getBuildingCost()
// REMEMBER: If changed you might want to change fieldsdata.txt and FieldLoader
// too :(
public class LotField extends OwnableField {

	private int houseCount, hotelCount;
	private LotColor color;
	private int housePrice;
	private int hotelPrice;
	private int[] rentTierList;

	public LotField(FieldType fieldType, int fieldNo, String text1, int price, int pawnPrice) {
		super(fieldType, fieldNo, text1, price, pawnPrice);
	}

	public int getBuildingCost() {
		return housePrice;
	}

	public void setRent(int[] rent) {
		this.rentTierList = rent;
	}

	public LotColor getColor() {
		return color;
	}

	public void setColor(LotColor color) {
		this.color = color;
	}

	public String toString() {
		return super.toString() + String.format(
				"Color:%s\n" + "Leje af grund: %s\n" + "Leje m. 1 hus: %s\n" + "Leje m. 2 huse: %s\n"
						+ "Leje m. 3 huse: %s\n" + "Leje m. 4 huse: %s\n" + "Leje m. hotel: %s\n",
				getColor(), getRentFor(LotRentTier.Lot), getRentFor(LotRentTier.OneHouse),
				getRentFor(LotRentTier.TwoHouses), getRentFor(LotRentTier.ThreeHouses),
				getRentFor(LotRentTier.FourHouses), getRentFor(LotRentTier.Hotel));
	}

	public int getRentFor(LotRentTier rentTier) {

		return this.rentTierList[rentTier.ordinal()];
	}

	public int getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;

	}

	public boolean changeHouseCount(int change) {
		if(houseCount+change>=0 && houseCount+change<5) {
			houseCount += change;
			return true;
		}
		return false;
		// TODO Auto-generated method stub
		
	}

	public int getHouseCount() {
		return houseCount;
	}
	
	public int getHotelCount() {
		return hotelCount;
	}

	public void setHouseCount(int i) {
		houseCount = i;		
	}

	public boolean changeHotelCount(int change) {
		if(houseCount+change>=0 && houseCount+change<2) {
			hotelCount += change;
			return true;
		}
		return false;
		
	}
}
