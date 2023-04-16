import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.List;

public class ComplexJsonParseSelf {
    public static void main(String[] args) {
        JsonPath js = new JsonPath(payload.CoursePrice());
        int courseSize = js.getInt("courses.size()");
        System.out.println(js.getString("dashboard.purchaseAmount"));
        System.out.println(js.getString("courses[0].title"));
        List<Integer> courses = js.getList("courses");
        for(int i=0;i<courseSize;i++){
            System.out.println(js.getString("courses["+i+"].title"));
            System.out.println(js.getString("courses["+i+"].price"));
        }

        for(int i=0;i<courseSize;i++){
            String title = (js.getString("courses["+i+"].title"));
            if(title.equals("RPA")){
                System.out.println("Copies sold is : "+ js.getString("courses["+i+"].copies"));
                break;
            }
        }
        int sum = 0;
        for(int i=0;i<courseSize;i++){
            int price = (js.getInt("courses["+i+"].price"));
            int copies = (js.getInt("courses["+i+"].copies"));
            sum+=(price*copies);
        }

        int purchasedAmt = js.getInt("dashboard.purchaseAmount");
        System.out.println(sum);
        System.out.println(purchasedAmt);
        Assert.assertEquals(sum,purchasedAmt);
    }
}
