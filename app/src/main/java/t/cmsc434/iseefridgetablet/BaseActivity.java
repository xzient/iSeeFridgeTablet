package t.cmsc434.iseefridgetablet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    Button mHomeBtn, mNotesBtn, mInventoryBtn, mShoppingListBtn, mMealsBtn, mUsersBtn,
        mAddToInventoryBtn, mUserParametersBtn, mSettingsBtn;

    Button previousBtn;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //Initiate all values
        mHomeBtn = findViewById(R.id.side_bar_home);
        mNotesBtn = findViewById(R.id.side_bar_notes);
        mInventoryBtn = findViewById(R.id.side_bar_inventory);
        mShoppingListBtn = findViewById(R.id.side_bar_shopping_list);
        mMealsBtn = findViewById(R.id.side_bar_meals);
        mUsersBtn = findViewById(R.id.side_bar_users);
        mAddToInventoryBtn = findViewById(R.id.side_bar_add_to_inventory);
        mUserParametersBtn = findViewById(R.id.side_bar_user_parameters);
        mSettingsBtn = findViewById(R.id.side_bar_settings);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //OnClickListeners
        mHomeBtn.setOnClickListener(onClickListener);
        mNotesBtn.setOnClickListener(onClickListener);
        mInventoryBtn.setOnClickListener(onClickListener);
        mShoppingListBtn.setOnClickListener(onClickListener);
        mMealsBtn.setOnClickListener(onClickListener);
        mUsersBtn.setOnClickListener(onClickListener);
        mAddToInventoryBtn.setOnClickListener(onClickListener);
        mUserParametersBtn.setOnClickListener(onClickListener);
        mSettingsBtn.setOnClickListener(onClickListener);


        previousBtn = findViewById(R.id.side_bar_home);
        previousBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            previousBtn = findViewById(R.id.side_bar_home);
            previousBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }




    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(previousBtn.getId() != view.getId()) {
                previousBtn.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                switch (view.getId()) {
                    case R.id.side_bar_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).addToBackStack(TAG).commit();
                        previousBtn = findViewById(view.getId());
                        previousBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case R.id.side_bar_notes:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NotesFragment()).addToBackStack(TAG).commit();
                        previousBtn = findViewById(view.getId());
                        previousBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case R.id.side_bar_inventory:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InventoryFragment()).addToBackStack(TAG).commit();
                        previousBtn = findViewById(view.getId());
                        previousBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case R.id.side_bar_shopping_list:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShoppingListFragment()).addToBackStack(TAG).commit();
                        previousBtn = findViewById(view.getId());
                        previousBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case R.id.side_bar_meals:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MealsFragment()).addToBackStack(TAG).commit();
                        previousBtn = findViewById(view.getId());
                        previousBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case R.id.side_bar_users:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UsersFragment()).addToBackStack(TAG).commit();
                        previousBtn = findViewById(view.getId());
                        previousBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case R.id.side_bar_add_to_inventory:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddToInventoryFragment()).addToBackStack(TAG).commit();
                        previousBtn = findViewById(view.getId());
                        previousBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case R.id.side_bar_user_parameters:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserParametersFragment()).addToBackStack(TAG).commit();
                        previousBtn = findViewById(view.getId());
                        previousBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    case R.id.side_bar_settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).addToBackStack(TAG).commit();
                        previousBtn = findViewById(view.getId());
                        previousBtn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                }

            }

        }
    };






}
