package tw.com.watsonfan.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button intentbtn1,intentbtn2,intentbtn3,intentbtn4,intentbtn5,intentbtn6;
    private EditText name,age;

    private TextView txtprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        Log.i("LCC","onCreate");

    }

    private void findViews(){
        intentbtn1 = findViewById(R.id.intentbtn1);
        intentbtn2 = findViewById(R.id.intentbtn2);
        intentbtn3 = findViewById(R.id.intentbtn3);
        intentbtn4 = findViewById(R.id.intentbtn4);
        intentbtn5 = findViewById(R.id.intentbtn5);
        intentbtn6 = findViewById(R.id.intentbtn6);

        name = findViewById(R.id.username);
        age = findViewById(R.id.userage);

        txtprice  = findViewById(R.id.txtprice);



        intentbtn1.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);

        });

        intentbtn2.setOnClickListener(v->{
            //撥電話使用
            Uri  uri = Uri.parse("tel:0988776655");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);

         }
        );

        intentbtn3.setOnClickListener(v->{
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });

        intentbtn4.setOnClickListener(v->{
            Uri uri = Uri.parse("http://www.google.com.tw");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        });

        intentbtn5.setOnClickListener(v->{
            /*
            多個變數要傳送時所使用的

            String UName = name.getText().toString();
            int UAge = Integer.parseInt(age.getText().toString());

            Bundle bundle = new Bundle();
            bundle.putString("UserName",UName);
            bundle.putInt("UserAge",UAge);

            Intent intent = new Intent(MainActivity.this,MainActivity2.class);

            intent.putExtras(bundle);

            startActivity(intent);
            */

            //單一一個變數要傳送時，可用
            String UName = name.getText().toString();
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("Name",UName);
            startActivity(intent);






        });

        intentbtn6.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this,MainActivity3.class);
            startActivityForResult(intent,101);
            //要由下一頁將值回傳回來用的。
            //requestCode 是來判斷是由那一個頁面回來
            // 例如：呼叫 camera  時，requestCode->100
            // 例如。呼叫 MainActivity3   ，  requestCode -> 101
        });
    }

    //android 回傳時，會自動呼叫此方法
    protected void onActivityResult(int requestCode,int ResultCode,Intent data) {
        super.onActivityResult(requestCode, ResultCode, data);

        if (requestCode == 100){
            switch(ResultCode){

            }
        }
        if (requestCode == 101){
            switch(ResultCode){

            }
        }




//        if (requestCode != 101)
//            return;   //中斷程式
//
//        switch(ResultCode){
//            case RESULT_OK:
//
//                Bundle bundle = data.getExtras();
//                int price = bundle.getInt("Price");
//                String product = bundle.getString("Product");
//                double pi = bundle.getDouble("Pi");
//                txtprice.setText(product + "-" + price + "-" + pi);
//
//                break;
//            case RESULT_CANCELED:
//                txtprice.setText("取消了！！！");
//                break;
//        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LCC","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LCC","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LCC","onDestroy");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LCC","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LCC","onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LCC","onPause");
    }
}