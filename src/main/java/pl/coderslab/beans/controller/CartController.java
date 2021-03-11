package pl.coderslab.beans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.Cart;
import pl.coderslab.app.CartItem;
import pl.coderslab.app.Product;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cartItems")
public class CartController {
    private Cart cart;

    @Autowired
    public CartController(Cart cart) {
        this.cart = cart;
    }

    @GetMapping("/add")
    public String add() {
        return "cart.jsp";
    }

    @GetMapping("/update")
    public String update(@RequestParam int quantity, @RequestParam String name, HttpSession session){
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        double sum;
        if (quantity == 1 || quantity == -1) {
            for (CartItem elem : cartItems) {
                if (elem.getProduct().getName().equals(name)) {
                    elem.setQuantity(quantity + elem.getQuantity());
                    session.setAttribute("cartItems", cartItems);
                    sum = getSum(cartItems);
                    session.setAttribute("sum", sum);
                    return "cart.jsp";
                }
            }

        }else if (quantity == 0){
            for (CartItem elem : cartItems){
                if(elem.getProduct().getName().equals(name)){
                    cartItems.remove(elem);
                    session.setAttribute("cartItems", cartItems);
                    sum = getSum(cartItems);
                    session.setAttribute("sum", sum);
                    return "cart.jsp";
                }
            }
        }

        return "cart.jsp";
    }

    @RequestMapping(value = "/addtocart", method = RequestMethod.POST)
    public String addtocart(@RequestParam String name, @RequestParam int quantity, @RequestParam double price, HttpSession session) {

        double sum;
        Product product = new Product(name, price);
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        for (CartItem elem : cartItems) {
            if (elem.getProduct().getName().equals(product.getName())) {
                elem.setQuantity(quantity + elem.getQuantity());
                session.setAttribute("cartItems", cartItems);
                sum = getSum(cartItems);
                session.setAttribute("sum", sum);
                return "cart.jsp";
            }
        }
        cartItems.add(new CartItem(quantity, product));
        session.setAttribute("cartItems", cartItems);
        sum = getSum(cartItems);
        session.setAttribute("sum", sum);
        return "cart.jsp";
    }

    public Double getSum(List<CartItem> cartItems) {
        double sum = 0;
        for (CartItem elem : cartItems) {
            sum += elem.getQuantity() * elem.getProduct().getPrice();
        }
        return sum;
    }
}
