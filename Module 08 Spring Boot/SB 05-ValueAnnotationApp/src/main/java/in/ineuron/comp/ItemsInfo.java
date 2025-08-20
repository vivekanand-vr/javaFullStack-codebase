package in.ineuron.comp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "info")
public class ItemsInfo {
	
	/*
	 * 	access modifier is public because these object values will be used in bill 
	 *  generator object
	 */
	@Value("${item.idli.price}")
	public float idlyPrice;

	@Value("${item.vada.price}")
	public float vadaPrice;

	@Value("${item.dosa.price}")
	public float dosaPrice;

	@Override
	public String toString() {
		return "ItemsInfo [idlyPrice=" + idlyPrice + ", vadaPrice=" + vadaPrice + ", dosaPrice=" + dosaPrice + "]";
	}
}
