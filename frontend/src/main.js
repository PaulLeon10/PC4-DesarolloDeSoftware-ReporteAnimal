import "./styles.css";
import { router } from "./router.js";

window.addEventListener("load", router);
window.addEventListener("hashchange", router);