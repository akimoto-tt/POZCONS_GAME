//パッケージ名
package com.example.pozcons_game;

//**********インポート**********
import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;
//**********インポート**********

public class MainActivity extends AppCompatActivity {


    //**********activity_main.xml で作成した TextView や ImageView を MainActivity.java で使うための準備です。**********
    private TextView scoreLabel;
    private TextView startLabel;

    private ImageView RunMan;

    private ImageView GreenEnemy;

    private ImageView Pink;


    /*
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private ImageView point1_RunMan;
    private ImageView point2_RunMan;
    private ImageView point3_RunMan;
    private ImageView point4_RunMan;
    private ImageView point5_RunMan;
    private ImageView point6_RunMan;
    private ImageView point7_RunMan;
    private ImageView point8_RunMan;
    private ImageView point9_RunMan;
    private ImageView point10_RunMan;
    private ImageView point11_RunMan;
    private ImageView point12_RunMan;
    private ImageView point13_RunMan;
    private ImageView point14_RunMan;
    private ImageView point15_RunMan;
    private ImageView point16_RunMan;
    private ImageView point17_RunMan;
    private ImageView point18_RunMan;
    private ImageView point19_RunMan;
    private ImageView point20_RunMan;
    private ImageView point21_RunMan;
    ////////////////////////////////////////////////////////////////////////////////////////////////
     */


    /*
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private ImageView point1_GreenEnemy;
    private ImageView point2_GreenEnemy;
    private ImageView point3_GreenEnemy;
    private ImageView point4_GreenEnemy;
    private ImageView point5_GreenEnemy;
    private ImageView point6_GreenEnemy;
    private ImageView point7_GreenEnemy;
    private ImageView point8_GreenEnemy;
    private ImageView point9_GreenEnemy;
    private ImageView point10_GreenEnemy;
    private ImageView point11_GreenEnemy;
    private ImageView point12_GreenEnemy;
    private ImageView point13_GreenEnemy;
    ////////////////////////////////////////////////////////////////////////////////////////////////
     */
    //**********activity_main.xml で作成した TextView や ImageView を MainActivity.java で使うための準備です。**********


    //ゲームの内容には関係ない  C言語でいう printf
    private final String TAG = "MainActivity_Log";


    // サイズ
    private int frameHeight;

    private int RunManXSize;
    private int RunManYSize;

    private  int GreenEnemyXSize;
    private  int GreenEnemyYSize;

    private  int PinkXSize;
    private  int PinkYSize;

    //端末の幅と高さ
    private int screenWidth;
    private int screenHeight;


    // 位置
    private float RunManX;
    private float RunManY;

    private float GreenEnemyX;
    private float GreenEnemyY;

    private float PinkX;
    private float PinkY;


    // スピード
    private int RunManSpeed;
    private int GreenEnemySpeed;
    private int PinkSpeed;


    // スコア
    private int score = 0;


    // Handler & Timer
    private Handler handler = new Handler();
    private Timer timer = new Timer();


    // 画面をタッチしたかしてないかの判定
    private boolean action_flg = false;


    //ゲームが始まったか始まってないかの判定
    private boolean start_flg = false;


    // Sound　音を鳴らすための変数
    private SoundPlayer soundPlayer;


    // Log出力で使うゲームには関係ない
    //int Judgment_Times = 0;


    /*
    //**********GreenEnemyのピクセル関連のデータ*******************************************************
    //GreenEnemyのピクセルサイズ
    int GreenEnemyPixelSizeX = 170;
    int GreenEnemyPixelSizeY = 170;

    //GreenEnemyの概形のピクセルデータの配列
    int[][] GreenEnemyOutlinePixel = {
            {20,40},
            {36,82},
            {64,13},
            {84,35},
            {103,15},
            {131,71},
            {163,109},
            {153,128},
            {132,99},
            {130,170},
            {37,170},
            {36,107},
            {8,70}
    };
    //**********GreenEnemyのピクセル関連のデータ*******************************************************
    */

    //GreenEnemyの座標データ配列を宣言 -> MakeRunManOutlinePosメソッドでオブジェクト作成する
    //int[][] GreenEnemyOutlinePos;

    /*
    //**********RumManのピクセル関連のデータ***********************************************************
    //RunManのピクセルサイズ
    int RunManPixelSizeX = 400;
    int RunManPixelSizeY = 400;

    //RunManの概形のピクセルデータの配列
    int[][] RunManOutlinePixel = {
            {60,210},
            {140,120},
            {243,142},
            {220,77},
            {286,19},
            {345,60},
            {349,142},
            {274,173},
            {317,203},
            {374,146},
            {331,228},
            {252,232},
            {277,270},
            {230,367},
            {230,280},
            {167,312},
            {32,359},
            {104,313},
            {128,240},
            {185,178},
            {141,162}
    };

    //**********RumManのピクセル関連のデータ***********************************************************
    */

    //RunManの座標データ配列を宣言 -> MakeRunManOutlinePosメソッドでオブジェクト作成する
    //int[][] RunManOutlinePos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //音を鳴らすためのオブジェクトを作成
        soundPlayer = new SoundPlayer(this);

        //************findViewById は「idからビューを見つける」という意味です。これをすることで MainActivity.java から TextView に表示する文字を変えたり、ImageView の位置を変えることができるようになります。**********
        scoreLabel = findViewById(R.id.scoreLabel);
        startLabel = findViewById(R.id.startLabel);
        RunMan = findViewById(R.id.run_man);
        GreenEnemy = findViewById(R.id.green_enemy);
        Pink = findViewById(R.id.pink);

        /*
        //point_RunMan = findViewById(R.id.point_RunMan);
        {
            ////////////////////////////////////////////////////////////////////////////////////////////
            point1_RunMan = findViewById(R.id.point1_RunMan);
            point2_RunMan = findViewById(R.id.point2_RunMan);
            point3_RunMan = findViewById(R.id.point3_RunMan);
            point4_RunMan = findViewById(R.id.point4_RunMan);
            point5_RunMan = findViewById(R.id.point5_RunMan);
            point6_RunMan = findViewById(R.id.point6_RunMan);
            point7_RunMan = findViewById(R.id.point7_RunMan);
            point8_RunMan = findViewById(R.id.point8_RunMan);
            point9_RunMan = findViewById(R.id.point9_RunMan);
            point10_RunMan = findViewById(R.id.point10_RunMan);
            point11_RunMan = findViewById(R.id.point11_RunMan);
            point12_RunMan = findViewById(R.id.point12_RunMan);
            point13_RunMan = findViewById(R.id.point13_RunMan);
            point14_RunMan = findViewById(R.id.point14_RunMan);
            point15_RunMan = findViewById(R.id.point15_RunMan);
            point16_RunMan = findViewById(R.id.point16_RunMan);
            point17_RunMan = findViewById(R.id.point17_RunMan);
            point18_RunMan = findViewById(R.id.point18_RunMan);
            point19_RunMan = findViewById(R.id.point19_RunMan);
            point20_RunMan = findViewById(R.id.point20_RunMan);
            point21_RunMan = findViewById(R.id.point21_RunMan);
            ////////////////////////////////////////////////////////////////////////////////////////////
        }
         */

        /*
        //point2_GreenEnemy= findViewById(R.id.point2_GreenEnemy);
        {
            ////////////////////////////////////////////////////////////////////////////////////////////
            point1_GreenEnemy = findViewById(R.id.point1_GreenEnemy);
            point2_GreenEnemy = findViewById(R.id.point2_GreenEnemy);
            point3_GreenEnemy = findViewById(R.id.point3_GreenEnemy);
            point4_GreenEnemy = findViewById(R.id.point4_GreenEnemy);
            point5_GreenEnemy = findViewById(R.id.point5_GreenEnemy);
            point6_GreenEnemy = findViewById(R.id.point6_GreenEnemy);
            point7_GreenEnemy = findViewById(R.id.point7_GreenEnemy);
            point8_GreenEnemy = findViewById(R.id.point8_GreenEnemy);
            point9_GreenEnemy = findViewById(R.id.point9_GreenEnemy);
            point10_GreenEnemy = findViewById(R.id.point10_GreenEnemy);
            point11_GreenEnemy = findViewById(R.id.point11_GreenEnemy);
            point12_GreenEnemy = findViewById(R.id.point12_GreenEnemy);
            point13_GreenEnemy = findViewById(R.id.point13_GreenEnemy);
            ////////////////////////////////////////////////////////////////////////////////////////////
        }
         */
        //************findViewById は「idからビューを見つける」という意味です。これをすることで MainActivity.java から TextView に表示する文字を変えたり、ImageView の位置を変えることができるようになります。**********

        // Screen Size
        WindowManager wm = getWindowManager();
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        //端末の画面の幅と高さ
        screenWidth = size.x;
        screenHeight = size.y;

        //Logでスクリーンサイズを確認 ゲームの内容には関係ない
        //Log.i(TAG, "screenWidth = " + size.x + "    screenHeight = " + size.y);

        //スクリーンサイズでスピードを決める
        RunManSpeed = Math.round(screenHeight / 60f);
        GreenEnemySpeed = Math.round(screenWidth / 60f);
        PinkSpeed = Math.round(screenWidth / 36f);

        //**********ゲーム開始前なので、pink・orange・blackは画面の外に移動させておきます。（ゲーム開始時に画面の右側から出てくるようにします。）**********
        //-80.0f という数値に意味はありません。
        //画像が完全に画面の外にでる数値ならば、-77.7f や -100.0f など何でも良いです。
        GreenEnemy.setX(-500.0f);
        GreenEnemy.setY(-500.0f);
        Pink.setX(-500.0f);
        Pink.setY(-500.0f);
        //**********ゲーム開始前なので、pink・orange・blackは画面の外に移動させておきます。（ゲーム開始時に画面の右側から出てくるようにします。）**********
        //-80.0f という数値に意味はありません。
        //画像が完全に画面の外にでる数値ならば、-77.7f や -100.0f など何でも良いです。

        //画面の上に表示されているスコアを "Score : 0" にする
        scoreLabel.setText("Score : 0");
    }


    public void changePos() {

        //changePos メソッド内でボックスとボールを動かす前に、毎回 hitCheck メソッドを呼ぶことで衝突判定を行います。
        hitCheck();

        //GreenEnemy
        {
            //GreenEnemyの位置を決める
            {
                //GreenEnemyのX座標を決める
                GreenEnemyX -= GreenEnemySpeed;

                //GreenEnemyのY座標を決める
                if (GreenEnemyX < 0) {
                    GreenEnemyX = screenWidth + 1000;
                    GreenEnemyY = frameHeight - GreenEnemyYSize;
                }
            }

            //GreenEnemyを配置
            GreenEnemy.setX(GreenEnemyX);
            GreenEnemy.setY(GreenEnemyY);
        }

        //pink
        {
            // Pinkの位置を決める
            {
                //pinkのX座標を決める
                PinkX -= PinkSpeed;

                //pinkのY座標を決める
                if (PinkX < 0) {
                    PinkX = screenWidth + 5000;
                    PinkY = frameHeight - PinkXSize;
                }
            }

            //pinkを配置
            Pink.setX(PinkX);
            Pink.setY(PinkY);
        }

        //RunMan
        {
            // RunManの位置を決める
            {
                //RunManのX座標を0にする
                RunManX = 100;

                //RunManのY座標を決める
                if (action_flg) {
                    if (RunManY == frameHeight - RunManYSize) {
                        if(RunManSpeed == 0) {
                            RunManSpeed = Math.round(screenHeight / 60f) * 5;
                        }
                    }
                }
                RunManY -= RunManSpeed;
            }

            //RunManの上方向へのスピードを減らす
            if(RunManY < frameHeight - RunManYSize) {
                RunManSpeed -= Math.round(screenHeight / 60f) / 2.5;
            }
            if(RunManY >= frameHeight - RunManYSize){
                RunManSpeed = 0;
            }

            //RunManの位置が画面から出ないか調べて出る場合は出ないように直す
            {
                //boxY が 0 より小さくなった場合は、青いボックスが frame の外に出ている状態です。
                //frame から出ないように boxY は 0 未満にならないようにします。
                if (RunManY < 0) RunManY = 0;

                //青いボックスが画面の一番下にある時、RunManY は frame の高さからボックスの高さを引いた値になります。
                //これ以上 RunManY の値が大きくなると画面から出てしまうので、frameHeight – RunManYSize よりも大きくならないようにします。
                if (RunManY > frameHeight - RunManYSize) RunManY = frameHeight - RunManYSize;
            }

            //RunManを配置
            {
                RunMan.setY(RunManY);
                RunMan.setX(RunManX);
            }

            //Log.i(TAG, "RunManX = " + RunManX + "     run_manY = " + run_manY);
        }

        /*
        /////////////////////////////////////////////////////////////////////////////////////////////
        {
            //point1_RunMan
            RunManOutlinePos[0][0] = (int) (RunManX + RunManOutlinePixel[0][0]);
            RunManOutlinePos[0][1] = (int) (RunManY + RunManOutlinePixel[0][1]);
            point1_RunMan.setX(RunManOutlinePos[0][0]);
            point1_RunMan.setY(RunManOutlinePos[0][1]);

            //point2_RunMan
            RunManOutlinePos[1][0] = (int) (RunManX + RunManOutlinePixel[1][0]);
            RunManOutlinePos[1][1] = (int) (RunManY + RunManOutlinePixel[1][1]);
            point2_RunMan.setX(RunManOutlinePos[1][0]);
            point2_RunMan.setY(RunManOutlinePos[1][1]);

            //point3_RunMan
            RunManOutlinePos[2][0] = (int) (RunManX + RunManOutlinePixel[2][0]);
            RunManOutlinePos[2][1] = (int) (RunManY + RunManOutlinePixel[2][1]);
            point3_RunMan.setX(RunManOutlinePos[2][0]);
            point3_RunMan.setY(RunManOutlinePos[2][1]);

            //point4_RunMan
            RunManOutlinePos[3][0] = (int) (RunManX + RunManOutlinePixel[3][0]);
            RunManOutlinePos[3][1] = (int) (RunManY + RunManOutlinePixel[3][1]);
            point4_RunMan.setX(RunManOutlinePos[3][0]);
            point4_RunMan.setY(RunManOutlinePos[3][1]);

            //point5_RunMan
            RunManOutlinePos[4][0] = (int) (RunManX + RunManOutlinePixel[4][0]);
            RunManOutlinePos[4][1] = (int) (RunManY + RunManOutlinePixel[4][1]);
            point5_RunMan.setX(RunManOutlinePos[4][0]);
            point5_RunMan.setY(RunManOutlinePos[4][1]);

            //point6_RunMan
            RunManOutlinePos[5][0] = (int) (RunManX + RunManOutlinePixel[5][0]);
            RunManOutlinePos[5][1] = (int) (RunManY + RunManOutlinePixel[5][1]);
            point6_RunMan.setX(RunManOutlinePos[5][0]);
            point6_RunMan.setY(RunManOutlinePos[5][1]);

            //point7_RunMan
            RunManOutlinePos[6][0] = (int) (RunManX + RunManOutlinePixel[6][0]);
            RunManOutlinePos[6][1] = (int) (RunManY + RunManOutlinePixel[6][1]);
            point7_RunMan.setX(RunManOutlinePos[6][0]);
            point7_RunMan.setY(RunManOutlinePos[6][1]);

            //point8_RunMan
            RunManOutlinePos[7][0] = (int) (RunManX + RunManOutlinePixel[7][0]);
            RunManOutlinePos[7][1] = (int) (RunManY + RunManOutlinePixel[7][1]);
            point8_RunMan.setX(RunManOutlinePos[7][0]);
            point8_RunMan.setY(RunManOutlinePos[7][1]);

            //point9_RunMan
            RunManOutlinePos[8][0] = (int) (RunManX + RunManOutlinePixel[8][0]);
            RunManOutlinePos[8][1] = (int) (RunManY + RunManOutlinePixel[8][1]);
            point9_RunMan.setX(RunManOutlinePos[8][0]);
            point9_RunMan.setY(RunManOutlinePos[8][1]);

            //point10_RunMan
            RunManOutlinePos[9][0] = (int) (RunManX + RunManOutlinePixel[9][0]);
            RunManOutlinePos[9][1] = (int) (RunManY + RunManOutlinePixel[9][1]);
            point10_RunMan.setX(RunManOutlinePos[9][0]);
            point10_RunMan.setY(RunManOutlinePos[9][1]);

            //point11_RunMan
            RunManOutlinePos[10][0] = (int) (RunManX + RunManOutlinePixel[10][0]);
            RunManOutlinePos[10][1] = (int) (RunManY + RunManOutlinePixel[10][1]);
            point11_RunMan.setX(RunManOutlinePos[10][0]);
            point11_RunMan.setY(RunManOutlinePos[10][1]);

            //point12_RunMan
            RunManOutlinePos[11][0] = (int) (RunManX + RunManOutlinePixel[11][0]);
            RunManOutlinePos[11][1] = (int) (RunManY + RunManOutlinePixel[11][1]);
            point12_RunMan.setX(RunManOutlinePos[11][0]);
            point12_RunMan.setY(RunManOutlinePos[11][1]);

            //point13_RunMan
            RunManOutlinePos[12][0] = (int) (RunManX + RunManOutlinePixel[12][0]);
            RunManOutlinePos[12][1] = (int) (RunManY + RunManOutlinePixel[12][1]);
            point13_RunMan.setX(RunManOutlinePos[12][0]);
            point13_RunMan.setY(RunManOutlinePos[12][1]);

            //point14_RunMan
            RunManOutlinePos[13][0] = (int) (RunManX + RunManOutlinePixel[13][0]);
            RunManOutlinePos[13][1] = (int) (RunManY + RunManOutlinePixel[13][1]);
            point14_RunMan.setX(RunManOutlinePos[13][0]);
            point14_RunMan.setY(RunManOutlinePos[13][1]);

            //point15_RunMan
            RunManOutlinePos[14][0] = (int) (RunManX + RunManOutlinePixel[14][0]);
            RunManOutlinePos[14][1] = (int) (RunManY + RunManOutlinePixel[14][1]);
            point15_RunMan.setX(RunManOutlinePos[14][0]);
            point15_RunMan.setY(RunManOutlinePos[14][1]);

            //point16_RunMan
            RunManOutlinePos[15][0] = (int) (RunManX + RunManOutlinePixel[15][0]);
            RunManOutlinePos[15][1] = (int) (RunManY + RunManOutlinePixel[15][1]);
            point16_RunMan.setX(RunManOutlinePos[15][0]);
            point16_RunMan.setY(RunManOutlinePos[15][1]);

            //point17_RunMan
            RunManOutlinePos[16][0] = (int) (RunManX + RunManOutlinePixel[16][0]);
            RunManOutlinePos[16][1] = (int) (RunManY + RunManOutlinePixel[16][1]);
            point17_RunMan.setX(RunManOutlinePos[16][0]);
            point17_RunMan.setY(RunManOutlinePos[16][1]);

            //point18_RunMan
            RunManOutlinePos[17][0] = (int) (RunManX + RunManOutlinePixel[17][0]);
            RunManOutlinePos[17][1] = (int) (RunManY + RunManOutlinePixel[17][1]);
            point18_RunMan.setX(RunManOutlinePos[17][0]);
            point18_RunMan.setY(RunManOutlinePos[17][1]);

            //point19_RunMan
            RunManOutlinePos[18][0] = (int) (RunManX + RunManOutlinePixel[18][0]);
            RunManOutlinePos[18][1] = (int) (RunManY + RunManOutlinePixel[18][1]);
            point19_RunMan.setX(RunManOutlinePos[18][0]);
            point19_RunMan.setY(RunManOutlinePos[18][1]);

            //point20_RunMan
            RunManOutlinePos[19][0] = (int) (RunManX + RunManOutlinePixel[19][0]);
            RunManOutlinePos[19][1] = (int) (RunManY + RunManOutlinePixel[19][1]);
            point20_RunMan.setX(RunManOutlinePos[19][0]);
            point20_RunMan.setY(RunManOutlinePos[19][1]);

            //point21_RunMan
            RunManOutlinePos[20][0] = (int) (RunManX + RunManOutlinePixel[20][0]);
            RunManOutlinePos[20][1] = (int) (RunManY + RunManOutlinePixel[20][1]);
            point21_RunMan.setX(RunManOutlinePos[20][0]);
            point21_RunMan.setY(RunManOutlinePos[20][1]);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
         */

        /*
        Log.i(TAG, "RunManX = " + RunManX);
        Log.i(TAG, "RunManOutlinePixel[20][0] = " + RunManOutlinePixel[20][0]);
        Log.i(TAG, "(int)(RunManX + RunManOutlinePixel[20][0]) = " + (int)(RunManX + RunManOutlinePixel[20][0]));
        Log.i(TAG, "RunManOutlinePos[20][0] = " + RunManOutlinePos[20][0]);
        Log.i(TAG, "RunManY = " + RunManY);
        Log.i(TAG, "RunManOutlinePixel[0][1] = " + RunManOutlinePixel[0][1]);
        Log.i(TAG, "(int)(RunManY + RunManOutlinePixel[0][1]) = " + (int)(RunManY + RunManOutlinePixel[0][1]));
        Log.i(TAG, "RunManOutlinePos[0][1] = " + RunManOutlinePos[0][1]);
         */

        /*
        ////////////////////////////////////////////////////////////////////////////////////////////
        {
            //point1_GreenEnemy
            GreenEnemyOutlinePos[0][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[0][0]);
            GreenEnemyOutlinePos[0][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[0][1]);
            point1_GreenEnemy.setX(GreenEnemyOutlinePos[0][0]);
            point1_GreenEnemy.setY(GreenEnemyOutlinePos[0][1]);

            //point2_GreenEnemy
            GreenEnemyOutlinePos[1][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[1][0]);
            GreenEnemyOutlinePos[1][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[1][1]);
            point2_GreenEnemy.setX(GreenEnemyOutlinePos[1][0]);
            point2_GreenEnemy.setY(GreenEnemyOutlinePos[1][1]);

            //point3_GreenEnemy
            GreenEnemyOutlinePos[2][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[2][0]);
            GreenEnemyOutlinePos[2][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[2][1]);
            point3_GreenEnemy.setX(GreenEnemyOutlinePos[2][0]);
            point3_GreenEnemy.setY(GreenEnemyOutlinePos[2][1]);

            //point4_GreenEnemy
            GreenEnemyOutlinePos[3][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[3][0]);
            GreenEnemyOutlinePos[3][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[3][1]);
            point4_GreenEnemy.setX(GreenEnemyOutlinePos[3][0]);
            point4_GreenEnemy.setY(GreenEnemyOutlinePos[3][1]);

            //point5_GreenEnemy
            GreenEnemyOutlinePos[4][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[4][0]);
            GreenEnemyOutlinePos[4][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[4][1]);
            point5_GreenEnemy.setX(GreenEnemyOutlinePos[4][0]);
            point5_GreenEnemy.setY(GreenEnemyOutlinePos[4][1]);

            //point6_GreenEnemy
            GreenEnemyOutlinePos[5][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[5][0]);
            GreenEnemyOutlinePos[5][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[5][1]);
            point6_GreenEnemy.setX(GreenEnemyOutlinePos[5][0]);
            point6_GreenEnemy.setY(GreenEnemyOutlinePos[5][1]);

            //point7_GreenEnemy
            GreenEnemyOutlinePos[6][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[6][0]);
            GreenEnemyOutlinePos[6][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[6][1]);
            point7_GreenEnemy.setX(GreenEnemyOutlinePos[6][0]);
            point7_GreenEnemy.setY(GreenEnemyOutlinePos[6][1]);

            //point8_GreenEnemy
            GreenEnemyOutlinePos[7][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[7][0]);
            GreenEnemyOutlinePos[7][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[7][1]);
            point8_GreenEnemy.setX(GreenEnemyOutlinePos[7][0]);
            point8_GreenEnemy.setY(GreenEnemyOutlinePos[7][1]);

            //point9_GreenEnemy
            GreenEnemyOutlinePos[8][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[8][0]);
            GreenEnemyOutlinePos[8][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[8][1]);
            point9_GreenEnemy.setX(GreenEnemyOutlinePos[8][0]);
            point9_GreenEnemy.setY(GreenEnemyOutlinePos[8][1]);

            //point10_GreenEnemy
            GreenEnemyOutlinePos[9][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[9][0]);
            GreenEnemyOutlinePos[9][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[9][1]);
            point10_GreenEnemy.setX(GreenEnemyOutlinePos[9][0]);
            point10_GreenEnemy.setY(GreenEnemyOutlinePos[9][1]);

            //point11_GreenEnemy
            GreenEnemyOutlinePos[10][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[10][0]);
            GreenEnemyOutlinePos[10][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[10][1]);
            point11_GreenEnemy.setX(GreenEnemyOutlinePos[10][0]);
            point11_GreenEnemy.setY(GreenEnemyOutlinePos[10][1]);

            //point12_GreenEnemy
            GreenEnemyOutlinePos[11][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[11][0]);
            GreenEnemyOutlinePos[11][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[11][1]);
            point12_GreenEnemy.setX(GreenEnemyOutlinePos[11][0]);
            point12_GreenEnemy.setY(GreenEnemyOutlinePos[11][1]);

            //point13_GreenEnemy
            GreenEnemyOutlinePos[12][0] = (int) (GreenEnemyX + GreenEnemyOutlinePixel[12][0]);
            GreenEnemyOutlinePos[12][1] = (int) (GreenEnemyY + GreenEnemyOutlinePixel[12][1]);
            point13_GreenEnemy.setX(GreenEnemyOutlinePos[12][0]);
            point13_GreenEnemy.setY(GreenEnemyOutlinePos[12][1]);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        */

        /*
        {
            Log.i(TAG, "GreenEnemyX = " + GreenEnemyX);
            Log.i(TAG, "GreenEnemyOutlinePixel[12][0] = " + GreenEnemyOutlinePixel[12][0]);
            Log.i(TAG, "(int)(GreenEnemyX + GreenEnemyOutlinePixel[12][0]) = " + (int) (GreenEnemyX + GreenEnemyOutlinePixel[12][0]));
            Log.i(TAG, "RunManOutlinePos[20][0] = " + RunManOutlinePos[20][0]);
            Log.i(TAG, "GreenEnemyY = " + GreenEnemyY);
            Log.i(TAG, "RunManOutlinePixel[0][1] = " + GreenEnemyOutlinePixel[12][1]);
            Log.i(TAG, "(int)(GreenEnemyY + GreenEnemyOutlinePixel[12][1]) = " + (int) (GreenEnemyY + GreenEnemyOutlinePixel[12][1]));
            Log.i(TAG, "GreenEnemyOutlinePos[12][1] = " + GreenEnemyOutlinePos[12][1]);
        }
         */

        //スコアを再表示 scoreの内容は hitCheck()内で変更
        scoreLabel.setText("Score : " + score);
    }

    //**********衝突判定**********
    public void hitCheck() {

        //GreenEnemyの衝突判定
        {
            // GreenEnemyの中心座標
            float GreenEnemyCenterX = GreenEnemyX + GreenEnemy.getWidth() / 2;
            float GreenEnemyCenterY = GreenEnemyY + GreenEnemy.getHeight() / 2;

            if (hitStatus(GreenEnemyCenterX, GreenEnemyCenterY)) {
                //ゲームオーバーの音を再生
                soundPlayer.playOverSound();

                // Game Over!
                if (timer != null) {
                    //タイマーをキャンセル(停止)
                    timer.cancel();
                    timer = null;
                }

                // 結果画面へ
                //今回は score（スコア）を ResultActivity（結果画面）で使いたいので、インテントを startActivity に渡す前に、この１行を書いています。
                //intent.putExtra("SCORE", score);
                //putExtra(取り出す時に使うキー, 渡したい値) のように使います。
                //キーは String（文字列）ですが、値は string, int, float などをセットすることができます。
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("SCORE", score);
                startActivity(intent);
            }
        }

        //Pinkの衝突判定
        {
            // Pinkの中心座標
            float pinkCenterX = PinkX + Pink.getWidth() / 2;
            float pinkCenterY = PinkY + Pink.getHeight() / 2;

            if (hitStatus(pinkCenterX, pinkCenterY)) {
                PinkX = -10.0f;
                score += 30;
                soundPlayer.playHitSound();
            }
        }
    }
    //**********衝突判定**********

    public boolean hitStatus(float centerX, float centerY) {
        return (RunManX <= centerX && centerX <= RunManX + RunManXSize &&
                RunManY <= centerY && centerY <= RunManY + RunManYSize) ? true : false;
    }

    @Override
    //**********画面をタップした時の処理**********(使ってみた感じだとタッチした瞬間、離した瞬間、指をスライドしているときの実行)
    public boolean onTouchEvent(MotionEvent event) {

        //start_flgがfalse の場合はゲーム開始前
        //start_flgがtrue の場合はゲームプレイ中
        //onTouchEvent では、初めて画面がタップされた時にstart_flg を true にする、startLabel を消す、タイマーを開始という処理を行います。
        //ここはゲーム開始時に一度だけ実行され、ゲームオーバーになって再びゲーム開始するまで実行されない
        if (start_flg == false) {

            //キャラクターの特徴点のPixelデータを画面のサイズに合わせる
            //PixeltoSize();

            //概形を入れるための配列オブジェクトを作成するメソッド
            //MakeOutlinePos();

            start_flg = true;

            //フレームレイアウトの高さを取得
            FrameLayout frame = findViewById(R.id.frame);
            frameHeight = frame.getHeight();

            //画面上での画像サイズを取得
            {
                RunManXSize = RunMan.getWidth();
                RunManYSize = RunMan.getHeight();

                //Log.i(TAG, "run_manXSize = " + RunManXSize + "     RunManYSize = " + RunManYSize);

                GreenEnemyXSize = GreenEnemy.getWidth();
                GreenEnemyYSize = GreenEnemy.getHeight();

                //Log.i(TAG, "GreenEnemyXSize = " + GreenEnemyXSize + "     GreenEnemyYSize = " + GreenEnemyYSize);

                PinkXSize = Pink.getWidth();
                PinkYSize = Pink.getHeight();

                //Log.i(TAG, "PinkXSize = " + PinkXSize + "     PinkYSize = " + PinkYSize);
            }

            RunManY = frameHeight - RunManYSize;

            //"タップしてスタート"の表示を消去(TextView や ImageView などの要素を非表示にしたい場合は、setVisibility メソッドを使います。INVISIBLE は非表示にするだけ、GONE は完全に消すという違いがあります。)
            startLabel.setVisibility(View.GONE);

            //**********タイマーの処理**********
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    //**********TimerTask taskで実行する処理**********
                    handler.post(new Runnable() {
                        @Override
                        //**********run() メソッドの中には繰り返し実行したい処理を書きます。**********
                        public void run() {
                            changePos();
                        }
                        //**********run() メソッドの中には繰り返し実行したい処理を書きます。**********
                    });

                    //20 ミリ秒毎に changePos() メソッドを呼び出して画面を更新していきますが、Android 開発では「メインスレッド外で UI を変更することはできない」という決まりがあります。
                    //言い換えると「TimerTask からはスコアラベルを更新できない」ということです。
                    //このとき使うのが Handler です。
                    //handler.post で UI スレッドに Runnable を渡して UI を更新するという方法で、changePos() メソッドを実行します。
                    //Handler を使わないと
                    //Only the original thread that created a view hierarchy can touch its views.
                    //というエラーメッセージが表示されます。
                    //**********TimerTask taskで実行する処理**********
                }
            }, 0, 20);

            //説明
            //schedule(TimerTask task, long delay, long period)
            //TimerTask task	実行する処理（タスク）
            //long delay	タスクを実行するまでに待機する時間（ミリ秒で指定）
            //long period	タスクの実行間隔（ミリ秒で指定）
            //ここでは待機時間は無しで、20ミリ秒毎にタスクを実行する

            //**********タイマーの処理**********

        } else {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //画面に触れたら action_flg を true
                action_flg = true;

            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                //画面から離したら action_flg を false
                action_flg = false;
            }
        }
        return true;
    }
    //**********画面をタップした時の処理**********

    @Override
    public void onBackPressed(){}


    public void PixeltoSize(){
        //**********RunManのピクセルデータをサイズに変換************************************************

        //Log
        /*
        Log.i(TAG, "runManPX.length = " + RunManOutlinePixel.length);
        Log.i(TAG, "RunMan.getWidth() = " + RunMan.getWidth());
        Log.i(TAG, "RunMan.getHeight() = " + RunMan.getHeight());
        Log.i(TAG, "RunManPixelSizeX = " + RunManPixelSizeX);
        Log.i(TAG, "RunManPixelSizeY = " + RunManPixelSizeY);
         */

        //Log
        /*
        Log.i(TAG, "GreenEnemyOutlinePixel.length = " + GreenEnemyOutlinePixel.length);
        Log.i(TAG, "GreenEnemy.getWidth() = " + GreenEnemy.getWidth());
        Log.i(TAG, "GreenEnemy.getHeight() = " + GreenEnemy.getHeight());
        Log.i(TAG, "GreenEnemyPixelSizeX = " + GreenEnemyPixelSizeX);
        Log.i(TAG, "GreenEnemyPixelSizeY = " + GreenEnemyPixelSizeY);
         */

        //int i;

        /*
        for(i=0;i<RunManOutlinePixel.length;i++){
            RunManOutlinePixel[i][0] = (int)((float)RunManOutlinePixel[i][0] * (float)RunMan.getWidth() / (float)RunManPixelSizeX);
            RunManOutlinePixel[i][1] = (int)((float)RunManOutlinePixel[i][1] * (float)RunMan.getHeight() / (float)RunManPixelSizeY);
        }
        //for(i=0;i<RunManOutlinePixel.length;i++) Log.i(TAG, RunManOutlinePixel[i][0] + " " + RunManOutlinePixel[i][1]);

        for(i=0;i<GreenEnemyOutlinePixel.length;i++){
            GreenEnemyOutlinePixel[i][0] = (int)((float)GreenEnemyOutlinePixel[i][0] * (float)GreenEnemy.getWidth() / (float)GreenEnemyPixelSizeX);
            GreenEnemyOutlinePixel[i][1] = (int)((float)GreenEnemyOutlinePixel[i][1] * (float)GreenEnemy.getHeight() / (float)GreenEnemyPixelSizeY);
        }
        for(i=0;i<GreenEnemyOutlinePixel.length;i++) Log.i(TAG, GreenEnemyOutlinePixel[i][0] + " " + GreenEnemyOutlinePixel[i][1]);
         */
        //**********RunManのピクセルデータをサイズに変換************************************************
    }



    /*
    public void MakeOutlinePos(){
        RunManOutlinePos  = new int[RunManOutlinePixel.length][RunManOutlinePixel[0].length];

        GreenEnemyOutlinePos = new int[GreenEnemyOutlinePixel.length][GreenEnemyOutlinePixel[0].length];
    }
     */

    //交差したらtrue しなかったらfalse
    /*
    public boolean IntersectionJudgment(int p1x,int p2x,int p3x,int p4x,
                                        int p1y,int p2y,int p3y,int p4y){
        boolean Intersection_Flag;

        if (((p1x - p2x) * (p3y - p1y) + (p1y - p2y) * (p1x - p3x)) * ((p1x - p2x) * (p4y - p1y) + (p1y - p2y) * (p1x - p4x)) < 0){
            if (((p3x - p4x) * (p1y - p3y) + (p3y - p4y) * (p3x - p1x))
                    * ((p3x - p4x) * (p2y - p3y) + (p3y - p4y) * (p3x - p2x)) < 0){
                Intersection_Flag = true;
            }
            else {
                Intersection_Flag = false;
            }
        }
        else{
            Intersection_Flag = false;
        }
        //Log.i(TAG, p1x + " " + p1y + " " + p2x + " " + p2y + " " + p3x + " " + p3y + " " + p4x + " " + p4y + " " + Intersection_Flag);
        return Intersection_Flag;
    }
     */
}