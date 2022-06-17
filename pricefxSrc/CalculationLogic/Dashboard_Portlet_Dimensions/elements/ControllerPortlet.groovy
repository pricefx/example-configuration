import net.pricefx.server.dto.calculation.DashboardController

final Integer INITIAL_WIDTH = 300  // 300 pixels
final Integer INITIAL_HEIGHT = 500  // 500 pixels

DashboardController controller = createSampleDashboardController()

// Sets initial width and height for the returned controller.
// Dashboard Controller represents the portlet, so this becomes initial portlet dimensions.
controller.withLayout(INITIAL_WIDTH, INITIAL_HEIGHT)    //<1>

return controller


/**
 * Sample dashboard controller, representing a portlet with html content
 * @return
 */
DashboardController createSampleDashboardController() {
    DashboardController controller = api.newController()
    controller.addButton("Show Products", AppPages.MD_PRODUCTS_PAGE)
    def lorem = "<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nullam sit amet magna in magna gravida vehicula. Aliquam id dolor. Cras elementum.</p>"
    (1..3).each { controller.addHTML(lorem) }
    return controller
}