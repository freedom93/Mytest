package com.freedom.testwxui;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnViewChangeListener, OnClickListener{
	private MyScrollLayout mScrollLayout;	
	private LinearLayout[] mImageViews;	
	private int mViewCount;	
	private int mCurSel;
	private ImageView add;
	
	private TextView liaotian;
	private TextView faxian;
	private TextView tongxunlu;
	private TextView wo;
	
	private boolean isOpen = false;
	
	private ListView listview1;
	private ListView listview2;
	
	//自定义的弹出框类
	SelectAddPopupWindow menuWindow; //弹出框
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init()
    {
		liaotian = (TextView)findViewById(R.id.liaotian);
		faxian = (TextView)findViewById(R.id.faxian);
		tongxunlu = (TextView)findViewById(R.id.tongxunlu);
		wo = (TextView)findViewById(R.id.wo);
		
		listview1 = (ListView)findViewById(R.id.listView1);
		listview2 = (ListView)findViewById(R.id.listView2);
		
		HuihuaAdapter ha = new HuihuaAdapter(this,getHuahui());
		listview1.setAdapter(ha);
		listview1.setCacheColorHint(0);
		
		ContactAdapter hc = new ContactAdapter(this,getContact());
		listview2.setAdapter(hc);
		listview2.setCacheColorHint(0);
		
    	mScrollLayout = (MyScrollLayout) findViewById(R.id.ScrollLayout); 	
    	LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lllayout);   	
    	mViewCount = mScrollLayout.getChildCount();
    	mImageViews = new LinearLayout[mViewCount];   	
    	for(int i = 0; i < mViewCount; i++)    	{
    		mImageViews[i] = (LinearLayout) linearLayout.getChildAt(i);
    		mImageViews[i].setEnabled(true);
    		mImageViews[i].setOnClickListener(this);
    		mImageViews[i].setTag(i);
    	}    	
    	mCurSel = 0;
    	mImageViews[mCurSel].setEnabled(false);    	
    	mScrollLayout.SetOnViewChangeListener(this);
    	
    	add = (ImageView)findViewById(R.id.add);
    	
    	add.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View arg0) {
    			uploadImage(MainActivity.this);
    		}
    	});
    }
	

	private ArrayList<ContactP> getContact(){
		ArrayList<ContactP> hcList = new ArrayList<ContactP>();
		ContactP c2 = new ContactP();
		c2.setTxPath(R.drawable.bind_mcontact_reco_friends+"");
		c2.setName("服务号");
		
		ContactP c15 = new ContactP();
		c15.setTxPath(R.drawable.headshow7+"");
		c15.setName("矫情兄弟");
		
		ContactP c1 = new ContactP();
		c1.setTxPath(R.drawable.bind_qq_icon+"");
		c1.setName("QQ团队");
		
		ContactP c0 = new ContactP();
		c0.setTxPath(R.drawable.icon+"");
		c0.setName("微信团队");
		
		ContactP c4 = new ContactP();
		c4.setTxPath(R.drawable.xiaohei+"");
		c4.setName("小黑");
		
		ContactP c5 = new ContactP();
		c5.setTxPath(R.drawable.headshow8+"");
		c5.setName("不再禽兽");
		
		ContactP c6 = new ContactP();
		c6.setTxPath(R.drawable.headshow3+"");
		c6.setName("SB不哭");
		
		ContactP c7 = new ContactP();
		c7.setTxPath(R.drawable.personactivity_cover_heart+"");
		c7.setName("Zoe");
		
		ContactP c8 = new ContactP();
		c8.setTxPath(R.drawable.headshow2+"");
		c8.setName("向西去大理");
		
		ContactP c9 = new ContactP();
		c9.setTxPath(R.drawable.headshow9+"");
		c9.setName("Marrey");
		
		ContactP c10 = new ContactP();
		c10.setTxPath(R.drawable.headshow4+"");
		c10.setName("旅怪");
		
		ContactP c11 = new ContactP();
		c11.setTxPath(R.drawable.headshow5+"");
		c11.setName("郝二");
		
		ContactP c12 = new ContactP();
		c12.setTxPath(R.drawable.headshow6+"");
		c12.setName("Sunshine");
		
		ContactP c13 = new ContactP();
		c13.setTxPath(R.drawable.headshow1+"");
		c13.setName("疯女");
		
		hcList.add(c0);
		hcList.add(c1);
		hcList.add(c2);
		hcList.add(c4);
		hcList.add(c5);
		hcList.add(c6);
		hcList.add(c7);
		hcList.add(c8);
		hcList.add(c9);
		hcList.add(c10);
		hcList.add(c11);
		hcList.add(c12);
		hcList.add(c13);
		hcList.add(c15);
		
		return hcList;
	}
	private ArrayList<HuiHua> getHuahui(){
		ArrayList<HuiHua> hhList = new ArrayList<HuiHua>();
		HuiHua h1 = new HuiHua();
		h1.setTxPath(R.drawable.headshow1+"");
		h1.setName1("疯女");
		h1.setLastContent("这是唯一一个正常的朋友");
		h1.setLastTime("下午 18:00");
		
		HuiHua h2 = new HuiHua();
		h2.setTxPath(R.drawable.xiaohei+"");
		h2.setName1("小黑");
		h2.setLastContent("我存在永恒的黑暗中，我喜欢吞噬光明的灵魂");
		h2.setLastTime("下午 17:40");
		
		HuiHua h3 = new HuiHua();
		h3.setTxPath(R.drawable.headshow3+"");
		h3.setName1("SB不哭");
		h3.setLastContent("傻逼不哭，站起来勇敢地撸");
		h3.setLastTime("下午 17:00");
		
		HuiHua h4 = new HuiHua();
		h4.setTxPath(R.drawable.headshow8+"");
		h4.setName1("不再禽兽");
		h4.setLastContent("从此不再当禽兽，我要当兽王");
		h4.setLastTime("下午 16:22");
		
		HuiHua h5 = new HuiHua();
		h5.setTxPath(R.drawable.headshow2+"");
		h5.setName1("向西去大理");
		h5.setLastContent("风吹得很清新，云飘荡在南边的天空");
		h5.setLastTime("下午 16:11");
		
		HuiHua h6 = new HuiHua();
		h6.setTxPath(R.drawable.headshow6+"");
		h6.setName1("Sunshine");
		h6.setLastContent("Don't look me, I will eat you, Are you know");
		h6.setLastTime("下午 15:08");
		
		HuiHua h7 = new HuiHua();
		h7.setTxPath(R.drawable.headshow5+"");
		h7.setName1("郝二");
		h7.setLastContent("没有那么大的屌，就不要装B");
		h7.setLastTime("下午 15:01");
		
		HuiHua h8 = new HuiHua();
		h8.setTxPath(R.drawable.headshow9+"");
		h8.setName1("Marrey");
		h8.setLastContent("我就是这么一个人，就是喜欢一个人，不管是不是一个人");
		h8.setLastTime("下午 14:50");
		
		HuiHua h9 = new HuiHua();
		h9.setTxPath(R.drawable.personactivity_cover_heart+"");
		h9.setName1("Zoe");
		h9.setLastContent("this is very good fill");
		h9.setLastTime("下午 14:00");
		
		HuiHua h0 = new HuiHua();
		h0.setTxPath(R.drawable.headshow1+"");
		h0.setName1("旅怪");
		h0.setLastContent("我是个喜欢就得人，但是你们一定要理解清楚我的名字，再跟我说话");
		h0.setLastTime("中午 12:00");
		
		hhList.add(h1);
		hhList.add(h2);
		hhList.add(h3);
		hhList.add(h4);
		hhList.add(h5);
		hhList.add(h6);
		hhList.add(h7);
		hhList.add(h8);
		hhList.add(h9);
		hhList.add(h0);
		return hhList;
	} 
	
	 public void uploadImage(final Activity context){
		 menuWindow = new SelectAddPopupWindow(MainActivity.this, itemsOnClick);
		 //显示窗口
		 menuWindow.showAtLocation(MainActivity.this.findViewById(R.id.add), Gravity.TOP|Gravity.RIGHT, 10, 118); //设置layout在PopupWindow中显示的位置
	 }
	 
	    //为弹出窗口实现监听类
	    private OnClickListener  itemsOnClick = new OnClickListener(){
	    	
	    	public void onClick(View v) {
	    		menuWindow.dismiss();
	    	}
	    };
	    
	private void setCurPoint(int index)
    {
    	if (index < 0 || index > mViewCount - 1 || mCurSel == index){
    		return ;
    	}    	
    	mImageViews[mCurSel].setEnabled(true);
    	mImageViews[index].setEnabled(false);    	
    	mCurSel = index;
    	
    	if(index == 0){
    		liaotian.setTextColor(0xff228B22);
    		faxian.setTextColor(Color.BLACK);
    		tongxunlu.setTextColor(Color.BLACK);
    		wo.setTextColor(Color.BLACK);
    	}else if(index==1){
    		liaotian.setTextColor(Color.BLACK);
    		faxian.setTextColor(0xff228B22);
    		tongxunlu.setTextColor(Color.BLACK);
    		wo.setTextColor(Color.BLACK);
    	}else if(index==2){
    		liaotian.setTextColor(Color.BLACK);
    		faxian.setTextColor(Color.BLACK);
    		tongxunlu.setTextColor(0xff228B22);
    		wo.setTextColor(Color.BLACK);
    	}else{
    		liaotian.setTextColor(Color.BLACK);
    		faxian.setTextColor(Color.BLACK);
    		tongxunlu.setTextColor(Color.BLACK);
    		wo.setTextColor(0xff228B22);
    	}
    }

    @Override
	public void OnViewChange(int view) {
		// TODO Auto-generated method stub
		setCurPoint(view);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int pos = (Integer)(v.getTag());
		setCurPoint(pos);
		mScrollLayout.snapToScreen(pos);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		 if ((keyCode == KeyEvent.KEYCODE_MENU)) {       
	            return true;
	        }
		return super.onKeyDown(keyCode, event);
	}

}
