const copyToClipboard = async () => {
    try {
        const element = document.querySelector(".user-select-all");
        await navigator.clipboard.writeText(element.textContent);
        console.log("Text copied to clipboard!");
        document.getElementById("copy-result").innerHTML = "Copied";

    } catch (error) {
        console.error("Failed to copy to clipboard:", error);
        document.getElementById("copy-result").innerHTML = "Not Copied";
    }
};