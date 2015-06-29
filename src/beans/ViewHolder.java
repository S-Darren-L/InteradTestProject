package beans;

import android.widget.TextView;


public class ViewHolder {
	
	public class PaymentCardsViewHolder extends ViewHolder{ 
		public TextView tvCardType;
		public TextView tvCardBalanceValue;
		public TextView tvCardCreditLable;
		public TextView tvCardCreditValue;
		public TextView tvCardNumber;
	}

	public class GiftCardsViewHolder extends ViewHolder {
		public TextView tvCardName;
		public TextView tvCardValue;
		public TextView tvCardNumber;
	}

	public class LoyaltyCardsViewHolder extends ViewHolder {
		public TextView tvCardName;
		public TextView tvHolderName;
		public TextView tvCardNumber;

	}

}
