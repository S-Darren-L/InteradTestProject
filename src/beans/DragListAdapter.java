package beans;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.GiftCardsModel;
import models.LoyaltyCardsModel;
import models.PaymentCardsModel;

import com.darren.liu.interadtestproject.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DragListAdapter extends BaseAdapter {
	private static final String TAG = "DragListAdapter";
	private ArrayList<Object> arrayListItemsList;
	private Context context;
	public boolean isHidden;

	private final int PAYMENT_CARD_TYPE = 0;
	private final int GIFT_CARD_TYPE = 1;
	private final int LOYALTY_CARD_TYPE = 2;

	public DragListAdapter(Context context, ArrayList<Object> paymentCardsList) {
		this.context = context;
		this.arrayListItemsList = paymentCardsList;
	}

	public void showDropItem(boolean showItem) {
		this.ShowItem = showItem;
	}

	public void setInvisiblePosition(int position) {
		invisilePosition = position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//initial view holder
		ViewHolder.PaymentCardsViewHolder paymentCardsViewHolder = null;
		ViewHolder.GiftCardsViewHolder giftCardsViewHolder = null;
		ViewHolder.LoyaltyCardsViewHolder loyaltyCardsViewHolder = null;
		int type = getItemViewType(position);

		//set payment card view
		if (type == PAYMENT_CARD_TYPE) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.payment_cards_listview_row, null);
			paymentCardsViewHolder = new ViewHolder().new PaymentCardsViewHolder();
			paymentCardsViewHolder.tvCardType = (TextView) convertView
					.findViewById(R.id.tvCardType);
			paymentCardsViewHolder.tvCardBalanceValue = (TextView) convertView
					.findViewById(R.id.tvCardBalanceValue);
			paymentCardsViewHolder.tvCardCreditLable = (TextView) convertView
					.findViewById(R.id.tvCardCreditLable);
			paymentCardsViewHolder.tvCardCreditValue = (TextView) convertView
					.findViewById(R.id.tvCardCreditValue);
			paymentCardsViewHolder.tvCardNumber = (TextView) convertView
					.findViewById(R.id.tvCardNumber);
			convertView.setTag(paymentCardsViewHolder);

			if (!((PaymentCardsModel) arrayListItemsList.get(position))
					.getCardCreditValue().equals("")) {
				paymentCardsViewHolder.tvCardCreditLable
						.setVisibility(View.VISIBLE);
				paymentCardsViewHolder.tvCardCreditValue
						.setVisibility(View.VISIBLE);
				paymentCardsViewHolder.tvCardCreditValue
						.setText("$"
								+ ((PaymentCardsModel) arrayListItemsList
										.get(position)).getCardCreditValue());
			}
			paymentCardsViewHolder.tvCardType
					.setText(((PaymentCardsModel) arrayListItemsList
							.get(position)).getCardType());
			paymentCardsViewHolder.tvCardBalanceValue.setText("$"
					+ ((PaymentCardsModel) arrayListItemsList.get(position))
							.getCardBalanceValue());
			paymentCardsViewHolder.tvCardNumber.setText("NO: "
					+ hideCardNumber(((PaymentCardsModel) arrayListItemsList.get(position))
							.getCardNumber()));
		} else if (type == GIFT_CARD_TYPE) {//set gift card view
			convertView = LayoutInflater.from(context).inflate(
					R.layout.gift_cards_listview_row, null);
			giftCardsViewHolder = new ViewHolder().new GiftCardsViewHolder();
			giftCardsViewHolder.tvCardName = (TextView) convertView
					.findViewById(R.id.tvCardName);
			giftCardsViewHolder.tvCardValue = (TextView) convertView
					.findViewById(R.id.tvCardValue);
			giftCardsViewHolder.tvCardNumber = (TextView) convertView
					.findViewById(R.id.tvCardNumber);
			convertView.setTag(giftCardsViewHolder);

			giftCardsViewHolder.tvCardName
					.setText(((GiftCardsModel) arrayListItemsList.get(position))
							.getCardName());
			giftCardsViewHolder.tvCardValue.setText("$"
					+ ((GiftCardsModel) arrayListItemsList.get(position))
							.getCardValue());
			giftCardsViewHolder.tvCardNumber.setText("NO: "
					+ hideCardNumber(((GiftCardsModel) arrayListItemsList.get(position))
							.getCardNumber()));
		} else if (type == LOYALTY_CARD_TYPE) {//set loyalty card view
			convertView = LayoutInflater.from(context).inflate(
					R.layout.loyalty_cards_listview_row, null);
			loyaltyCardsViewHolder = new ViewHolder().new LoyaltyCardsViewHolder();
			loyaltyCardsViewHolder.tvCardName = (TextView) convertView
					.findViewById(R.id.tvCardName);
			loyaltyCardsViewHolder.tvHolderName = (TextView) convertView
					.findViewById(R.id.tvHolderName);
			loyaltyCardsViewHolder.tvCardNumber = (TextView) convertView
					.findViewById(R.id.tvCardNumber);
			convertView.setTag(loyaltyCardsViewHolder);

			loyaltyCardsViewHolder.tvCardName
					.setText(((LoyaltyCardsModel) arrayListItemsList
							.get(position)).getCardName());
			loyaltyCardsViewHolder.tvHolderName
					.setText(((LoyaltyCardsModel) arrayListItemsList
							.get(position)).getHolderName());
			loyaltyCardsViewHolder.tvCardNumber.setText("NO: "
					+ hideCardNumber(((LoyaltyCardsModel) arrayListItemsList.get(position))
							.getCardNumber()));
		}
		return convertView;
	}

	//hide card number
	public String hideCardNumber(String CardNumber) {
		Pattern PATTERN = Pattern.compile("[0-9]+");
		Matcher matcher = PATTERN.matcher(CardNumber);
		String maskingChar = "*";
		StringBuilder finalMask = new StringBuilder(maskingChar);

		while (matcher.find()) {
			String group = matcher.group();
			int groupLen = group.length();

			if (groupLen > 4) {
				for (int i = 0; i <= group.length() - 4; i++) {
					finalMask.append(maskingChar);
				}
				finalMask.append(group.substring(groupLen - 4));
			}
			CardNumber = CardNumber.replace(group, finalMask);
		}
		return CardNumber;
	}

	@Override
	public int getItemViewType(int position) {
		if (arrayListItemsList.get(position) instanceof PaymentCardsModel) {
			return PAYMENT_CARD_TYPE;
		} else if (arrayListItemsList.get(position) instanceof GiftCardsModel) {
			return GIFT_CARD_TYPE;
		} else {
			return LOYALTY_CARD_TYPE;
		}
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	
//	  change ListVIiw position
//	  
//	  @param start
//	             start to move position
//	  @param down
//	             stop to move position
	
	private int invisilePosition = -1;
	private boolean isChanged = true;
	private boolean ShowItem = false;

	public void exchange(int startPosition, int endPosition) {
		System.out.println(startPosition + "--" + endPosition);
		// holdPosition = endPosition;
		Object startObject = getItem(startPosition);
		System.out.println(startPosition + "========" + endPosition);
		Log.d("ON", "startPostion ==== " + startPosition);
		Log.d("ON", "endPosition ==== " + endPosition);
		if (startPosition < endPosition) {
			arrayListItemsList.add(endPosition + 1, (String) startObject);
			arrayListItemsList.remove(startPosition);
		} else {
			arrayListItemsList.add(endPosition, (String) startObject);
			arrayListItemsList.remove(startPosition + 1);
		}
		isChanged = true;
	}

	public void exchangeCopy(int startPosition, int endPosition) {
		System.out.println(startPosition + "--" + endPosition);
		Object startObject = getCopyItem(startPosition);
		System.out.println(startPosition + "========" + endPosition);
		Log.d("ON", "startPostion ==== " + startPosition);
		Log.d("ON", "endPosition ==== " + endPosition);
		if (startPosition < endPosition) {
			mCopyList.add(endPosition + 1, (Object) startObject);
			mCopyList.remove(startPosition);
		} else {
			mCopyList.add(endPosition, (Object) startObject);
			mCopyList.remove(startPosition + 1);
		}
		isChanged = true;
	}

	public Object getCopyItem(int position) {
		return mCopyList.get(position);
	}

	@Override
	public int getCount() {
		return arrayListItemsList.size();
	}

	@Override
	public Object getItem(int position) {
		return arrayListItemsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void addDragItem(int start, Object obj) {
		Log.i(TAG, "start" + start);
		Object title = arrayListItemsList.get(start);
		arrayListItemsList.remove(start);
		arrayListItemsList.add(start, (String) obj);
	}

	private ArrayList<Object> mCopyList = new ArrayList<Object>();

	public void copyList() {
		mCopyList.clear();
		for (Object str : arrayListItemsList) {
			mCopyList.add(str);
		}
	}

	public void pastList() {
		arrayListItemsList.clear();
		for (Object str : mCopyList) {
			arrayListItemsList.add(str);
		}
	}

	private boolean isSameDragDirection = true;
	private int lastFlag = -1;
	private int height;
	private int dragPosition = -1;

	public void setIsSameDragDirection(boolean value) {
		isSameDragDirection = value;
	}

	public void setLastFlag(int flag) {
		lastFlag = flag;
	}

	public void setHeight(int value) {
		height = value;
	}

	public void setCurrentDragPosition(int position) {
		dragPosition = position;
	}

	public Animation getFromSelfAnimation(int x, int y) {
		TranslateAnimation go = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, x,
				Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, y);
		go.setInterpolator(new AccelerateDecelerateInterpolator());
		go.setFillAfter(true);
		go.setDuration(100);
		go.setInterpolator(new AccelerateInterpolator());
		return go;
	}

	public Animation getToSelfAnimation(int x, int y) {
		TranslateAnimation go = new TranslateAnimation(Animation.ABSOLUTE, x,
				Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, y,
				Animation.RELATIVE_TO_SELF, 0);
		go.setInterpolator(new AccelerateDecelerateInterpolator());
		go.setFillAfter(true);
		go.setDuration(100);
		go.setInterpolator(new AccelerateInterpolator());
		return go;
	}
}
